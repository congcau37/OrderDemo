package vn.com.misa.orderdemo.login.LoginPhoneNumber;

/**
 *
 * @created_by tdcong
 * @date 5/20/2019
 */
public interface ILogin {
    interface IGetAccountCallback {
        void checkAccount(boolean check);
    }

    void getAccount(String userName, String passWord, IGetAccountCallback callback);

    boolean checkAccountDB(String userName, String passWord);
}
