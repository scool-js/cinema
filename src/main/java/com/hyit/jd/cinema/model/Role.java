package com.hyit.jd.cinema.model;

public class Role {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.id
     *
     * @mbg.generated Fri Mar 13 21:03:28 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.permission
     *
     * @mbg.generated Fri Mar 13 21:03:28 CST 2020
     */
    private String permission;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.role
     *
     * @mbg.generated Fri Mar 13 21:03:28 CST 2020
     */
    private String role;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.id
     *
     * @return the value of role.id
     *
     * @mbg.generated Fri Mar 13 21:03:28 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.id
     *
     * @param id the value for role.id
     *
     * @mbg.generated Fri Mar 13 21:03:28 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.permission
     *
     * @return the value of role.permission
     *
     * @mbg.generated Fri Mar 13 21:03:28 CST 2020
     */
    public String getPermission() {
        return permission;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.permission
     *
     * @param permission the value for role.permission
     *
     * @mbg.generated Fri Mar 13 21:03:28 CST 2020
     */
    public void setPermission(String permission) {
        this.permission = permission == null ? null : permission.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.role
     *
     * @return the value of role.role
     *
     * @mbg.generated Fri Mar 13 21:03:28 CST 2020
     */
    public String getRole() {
        return role;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.role
     *
     * @param role the value for role.role
     *
     * @mbg.generated Fri Mar 13 21:03:28 CST 2020
     */
    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }
}