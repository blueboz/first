package cn.boz.domain.pojo;

public class ActIdGroup {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column act_id_group.ID_
     *
     * @mbg.generated Sun Aug 26 11:58:27 CST 2018
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column act_id_group.REV_
     *
     * @mbg.generated Sun Aug 26 11:58:27 CST 2018
     */
    private Integer rev;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column act_id_group.NAME_
     *
     * @mbg.generated Sun Aug 26 11:58:27 CST 2018
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column act_id_group.TYPE_
     *
     * @mbg.generated Sun Aug 26 11:58:27 CST 2018
     */
    private String type;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column act_id_group.ID_
     *
     * @return the value of act_id_group.ID_
     *
     * @mbg.generated Sun Aug 26 11:58:27 CST 2018
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column act_id_group.ID_
     *
     * @param id the value for act_id_group.ID_
     *
     * @mbg.generated Sun Aug 26 11:58:27 CST 2018
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column act_id_group.REV_
     *
     * @return the value of act_id_group.REV_
     *
     * @mbg.generated Sun Aug 26 11:58:27 CST 2018
     */
    public Integer getRev() {
        return rev;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column act_id_group.REV_
     *
     * @param rev the value for act_id_group.REV_
     *
     * @mbg.generated Sun Aug 26 11:58:27 CST 2018
     */
    public void setRev(Integer rev) {
        this.rev = rev;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column act_id_group.NAME_
     *
     * @return the value of act_id_group.NAME_
     *
     * @mbg.generated Sun Aug 26 11:58:27 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column act_id_group.NAME_
     *
     * @param name the value for act_id_group.NAME_
     *
     * @mbg.generated Sun Aug 26 11:58:27 CST 2018
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column act_id_group.TYPE_
     *
     * @return the value of act_id_group.TYPE_
     *
     * @mbg.generated Sun Aug 26 11:58:27 CST 2018
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column act_id_group.TYPE_
     *
     * @param type the value for act_id_group.TYPE_
     *
     * @mbg.generated Sun Aug 26 11:58:27 CST 2018
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}