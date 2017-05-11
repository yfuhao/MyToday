package text.bwie.today.utils;

/**
 * Created by lenovo-pc on 2017/5/11.
 */

public class RegisterBean {

    /**
     * ret_code : 0
     * ret_msg : 参数不对或权限不足
     */

    private int ret_code;
    private String ret_msg;
    /**
     * result : {"id":33,"password":"123","username":"13865821059"}
     */

    private ResultBean result;

    public int getRet_code() {
        return ret_code;
    }

    public void setRet_code(int ret_code) {
        this.ret_code = ret_code;
    }

    public String getRet_msg() {
        return ret_msg;
    }

    public void setRet_msg(String ret_msg) {
        this.ret_msg = ret_msg;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * id : 33
         * password : 123
         * username : 13865821059
         */

        private int id;
        private String password;
        private String username;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}
