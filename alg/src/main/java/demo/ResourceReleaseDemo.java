package demo;

import java.io.*;

public class ResourceReleaseDemo implements AutoCloseable{
    @Override
    public void close() throws Exception {
        System.out.println("resource release");
    }
    public void use() throws Exception {
        try (ResourceReleaseDemo resourceRelease = new ResourceReleaseDemo()){
            System.out.println("use resource");
        }
    }

    /**
     * 多资源管理
     * @param fromPath
     * @param toPath
     * @throws IOException
     */
    public void copyFile(String fromPath,String toPath) throws IOException{
        try (InputStream input = new FileInputStream(fromPath);
             OutputStream output = new FileOutputStream(toPath)){
            byte[] buffer = new byte[8192];
            int len = -1;
            while ((len = input.read(buffer))!= -1){
                output.write(buffer,0,len);
            }
        }
    }
}
