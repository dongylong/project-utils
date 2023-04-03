package demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定菜单记录列表（按照名称排序），每条菜单记录中包含父菜单标识（根菜单的父菜单标识为null），构建出整个菜单树。
 * 原始类: MenuDO(Long id, Long parentId, String name, String url)
 * 目标类: MenuVO(Long id, String name, String url, List<MenuVO> childList);
 * 实现函数: public static List<MenuVO> buildMenuTree(List<MenuDO> menuList);
 * 备注: 只使用一次列表遍历实现.
 */
public class BuildMenuTree {

    public static List<MenuVO> buildMenuTreeWithMap(List<MenuDO> menuList) {
        Map<Long, List<MenuVO>> voMap = new HashMap<>();
        List<MenuVO> menuVORespList = new ArrayList<>();
        for (MenuDO menuDO : menuList) {
            MenuVO vo = new MenuVO();
            Long id = menuDO.getId();
            vo.setName(menuDO.getName());
            vo.setId(id);
            vo.setParentId(menuDO.getParentId());
            vo.setUrl(menuDO.getUrl());
            if (!voMap.containsKey(id)) {
                voMap.put(id, new ArrayList<>());
            }
            vo.setChildList(voMap.get(id));
            menuVORespList.add(vo);
            Long pId = menuDO.getParentId();
            if (voMap.containsKey(pId)) {
                List<MenuVO> menuVOList = voMap.get(pId);
                menuVOList.add(vo);
            } else {
                //新增
                List<MenuVO> childList = new ArrayList<>();
                childList.add(vo);
                voMap.put(pId, childList);
            }
        }
        return menuVORespList;
    }

    public static void main(String[] args) {
        List<MenuDO> menuList = assembleList();
        List<MenuVO> menuVOList = buildMenuTreeWithMap(menuList);
        System.out.println(menuVOList);
    }

    private static MenuDO assembleDO(Long id, Long pId) {
        MenuDO menuDO = new MenuDO();
        menuDO.setId(id);
        menuDO.setParentId(pId);
        menuDO.setName(id + "");
        menuDO.setUrl(id + "");
        return menuDO;
    }

    private static List<MenuDO> assembleList() {
        List<MenuDO> menuList = new ArrayList<>();

        menuList.add(assembleDO(1L, null));
        menuList.add(assembleDO(2L, 1L));
        menuList.add(assembleDO(3L, 1L));
        menuList.add(assembleDO(4L, 3L));
        menuList.add(assembleDO(5L, 6L));
        menuList.add(assembleDO(6L, 2L));
        return menuList;
    }
}
