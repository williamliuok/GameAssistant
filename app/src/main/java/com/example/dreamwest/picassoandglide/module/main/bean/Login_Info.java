package com.example.dreamwest.picassoandglide.module.main.bean;

/**
 * Created by Administrator on 16-6-28.
 */
public class Login_Info {

    /**
     * uid : 318529440
     * detail_address :
     * hpic : http://www.yuu1.com//data/avatar/avatar_6.png
     * nickname : 梦凡星西
     * qq :
     * receiver : 15096064450
     * sex : 1
     * phone : 15096064450
     * username : 15096064450
     * score : 1250
     * expend : 1250
     * code : 100880
     * invite_num : 0
     * today_profit : 0
     * token : e989PqIdZhR25dkxCQUO5B4qeR38mLETnBPzqwHlBh9YI+j99I47M4isQTIfWGgzTS2iMQyMBQ
     */

    private InfoBean info;
    /**
     * info : {"uid":"318529440","detail_address":"","hpic":"http://www.yuu1.com//data/avatar/avatar_6.png","nickname":"梦凡星西","qq":"","receiver":"15096064450","sex":"1","phone":"15096064450","username":"15096064450","score":"1250","expend":"1250","code":"100880","invite_num":0,"today_profit":0,"token":"e989PqIdZhR25dkxCQUO5B4qeR38mLETnBPzqwHlBh9YI+j99I47M4isQTIfWGgzTS2iMQyMBQ"}
     * page : null
     * state : success
     */

    private Object page;
    private String state;

    public InfoBean getInfo() {
        return info;
    }

    public void setInfo(InfoBean info) {
        this.info = info;
    }

    public Object getPage() {
        return page;
    }

    public void setPage(Object page) {
        this.page = page;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public static class InfoBean {
        private String uid;
        private String detail_address;
        private String hpic;
        private String nickname;
        private String qq;
        private String receiver;
        private String sex;
        private String phone;
        private String username;
        private String score;
        private String expend;
        private String code;
        private int invite_num;
        private int today_profit;
        private String token;

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getDetail_address() {
            return detail_address;
        }

        public void setDetail_address(String detail_address) {
            this.detail_address = detail_address;
        }

        public String getHpic() {
            return hpic;
        }

        public void setHpic(String hpic) {
            this.hpic = hpic;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getQq() {
            return qq;
        }

        public void setQq(String qq) {
            this.qq = qq;
        }

        public String getReceiver() {
            return receiver;
        }

        public void setReceiver(String receiver) {
            this.receiver = receiver;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }

        public String getExpend() {
            return expend;
        }

        public void setExpend(String expend) {
            this.expend = expend;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public int getInvite_num() {
            return invite_num;
        }

        public void setInvite_num(int invite_num) {
            this.invite_num = invite_num;
        }

        public int getToday_profit() {
            return today_profit;
        }

        public void setToday_profit(int today_profit) {
            this.today_profit = today_profit;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
