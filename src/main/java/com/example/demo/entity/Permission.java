package com.example.demo.entity;

public class Permission {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column permission.id
     *
     * @mbggenerated Wed Jan 09 14:41:30 CST 2019
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column permission.permissionname
     *
     * @mbggenerated Wed Jan 09 14:41:30 CST 2019
     */
    private String permissionname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column permission.roleid
     *
     * @mbggenerated Wed Jan 09 14:41:30 CST 2019
     */
    private Integer roleid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column permission.id
     *
     * @return the value of permission.id
     *
     * @mbggenerated Wed Jan 09 14:41:30 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column permission.id
     *
     * @param id the value for permission.id
     *
     * @mbggenerated Wed Jan 09 14:41:30 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column permission.permissionname
     *
     * @return the value of permission.permissionname
     *
     * @mbggenerated Wed Jan 09 14:41:30 CST 2019
     */
    public String getPermissionname() {
        return permissionname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column permission.permissionname
     *
     * @param permissionname the value for permission.permissionname
     *
     * @mbggenerated Wed Jan 09 14:41:30 CST 2019
     */
    public void setPermissionname(String permissionname) {
        this.permissionname = permissionname == null ? null : permissionname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column permission.roleid
     *
     * @return the value of permission.roleid
     *
     * @mbggenerated Wed Jan 09 14:41:30 CST 2019
     */
    public Integer getRoleid() {
        return roleid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column permission.roleid
     *
     * @param roleid the value for permission.roleid
     *
     * @mbggenerated Wed Jan 09 14:41:30 CST 2019
     */
    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }
}