package demo;

import java.util.List;

public class MenuVO {
    Long id;
    String name;
    String url;
    Long parentId;

    List<MenuVO> childList;

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<MenuVO> getChildList() {
        return childList;
    }

    public void setChildList(List<MenuVO> childList) {
        this.childList = childList;
    }
}
