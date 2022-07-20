package com.latte.utils;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SearchAttraction {

	//输入文件字段分隔符
	public static final String INFILE_DELIMITER = (char) 1 + "";
	//输出文件字段分隔符
	public static final String OUTFILE_DELIMITER = (char) 1 + "";

	private static ArrayList<String> attractionsList = new ArrayList<String>();

	public static class AttractionMapper extends Mapper<LongWritable, Text, NullWritable, Text> {
		protected void setup(Context context) throws IOException, InterruptedException {
			String attractionCfg = "/config/domestic_attraction.cfg";
			InputStream is = null;
			BufferedReader br = null;
			try {
				is = this.getClass().getResourceAsStream(attractionCfg);
				br = new BufferedReader(new InputStreamReader(is));
				String strInfo = null;
				while ((strInfo = br.readLine()) != null) {
					attractionsList.add(strInfo.trim());
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				br.close();
				is.close();
			}
		}

		public void map(LongWritable ikey, Text ivalue, Context context) throws IOException,
				InterruptedException {
			String dpiLine = ivalue.toString();
			if (StringUtils.isBlank(dpiLine)) {
				return;
			}

			String[] dpiInfo = dpiLine.split(INFILE_DELIMITER, -1);

			//关键字keywords，在清单表中的第7个字段
			String keywords = dpiInfo[6];
			String attraction = null;
			for (String str : attractionsList) {
				if (keywords.contains(str)) {
					attraction = str;
					break;
				}
			}

			//丢弃不包含景点记录
			if (StringUtils.isBlank(attraction)) {
				return;
			}

			/*
			 * 手机号码 访问开始时间 访问时长 访问流量 位置区编码 流量类型 搜索关键字 搜索网站 搜索网站一级域名 搜索引擎分类
			 * 搜索关键字分类
			 */
			// 安讯话单格式字段获取

			StringBuffer record = new StringBuffer();
			record.append(dpiInfo[0]).append(OUTFILE_DELIMITER);
			record.append(dpiInfo[1]).append(OUTFILE_DELIMITER);
			record.append(dpiInfo[2]).append(OUTFILE_DELIMITER);
			record.append(dpiInfo[3]).append(OUTFILE_DELIMITER);
			record.append(dpiInfo[4]).append(OUTFILE_DELIMITER);
			record.append(dpiInfo[5]).append(OUTFILE_DELIMITER);
			record.append(dpiInfo[6]).append(OUTFILE_DELIMITER);
			record.append(dpiInfo[7]).append(OUTFILE_DELIMITER);
			record.append(dpiInfo[8]).append(OUTFILE_DELIMITER);
			record.append(dpiInfo[9]).append(OUTFILE_DELIMITER);
			record.append(dpiInfo[10]).append(OUTFILE_DELIMITER);
			record.append(attraction).append(OUTFILE_DELIMITER);

			String strrecord = record.toString();
			// 3.将结果清单信息写入到文件
			if (StringUtils.isNotBlank(strrecord)) {
				context.write(NullWritable.get(), new Text(strrecord));
			}
		}
	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("请输入DPI文件的目录和输出目录");
			System.exit(1);
		}

		Path input = new Path(args[0]);
		Path output = new Path(args[1]);

		Configuration conf = new Configuration();

		Job job;
		try {
			job = new Job(conf);
			job.setJobName("GetSearchAttraction");
			job.setJarByClass(SearchAttraction.class);
			job.setMapperClass(AttractionMapper.class);

			job.setOutputKeyClass(NullWritable.class);
			job.setOutputValueClass(Text.class);

			FileInputFormat.addInputPath(job, input);
			FileOutputFormat.setOutputPath(job, output);

			System.exit(job.waitForCompletion(true) ? 0 : 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
