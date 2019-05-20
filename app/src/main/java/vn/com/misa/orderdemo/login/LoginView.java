package vn.com.misa.orderdemo.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import vn.com.misa.orderdemo.MainApp;
import vn.com.misa.orderdemo.R;

/**
 * class đăng nhập
 * @created_by tdcong
 * @date 5/17/2019
 */
public class LoginView extends AppCompatActivity implements ILoginContract.ILoginView {

    @BindView(R.id.etInputEmail)
    EditText etInputEmail;
    @BindView(R.id.etInputPassword)
    EditText etInputPassword;
    @BindView(R.id.btnLogin)
    AppCompatButton btnLogin;
    @BindView(R.id.tvLinkSignUp)
    TextView tvLinkSignUp;
    @BindView(R.id.cbSaveLogin)
    CheckBox cbSaveLogin;

    String userName, passWord;
    LoginPresenter iLoginPresenter;
    String shfKey = "save login";// key để lưu thông tin đăng nhập

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login_app);
            ButterKnife.bind(this);
            initPresenter();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @OnClick(R.id.btnLogin)
    public void onViewClicked() {
        try {
            getTextAccount();
            iLoginPresenter.loadAccount(userName, passWord);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Hàm khởi tạo presenter
     * @param
     * @return
     */
    private void initPresenter() {
        iLoginPresenter = new LoginPresenter(new LoginModel(), this);
    }

    /**
     * Hàm lấy thông tin đăng nhập
     */
    public void getTextAccount() {
        try {
            userName = etInputEmail.getText().toString().trim();
            passWord = etInputPassword.getText().toString().trim();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Hàm
     *
     * @param
     * @return
     * @created_by tdcong
     * @date 5/17/2019
     */
    @Override
    public void showOnSuccess() {
        try {
            startActivity(new Intent(LoginView.this, MainApp.class));
            Toast.makeText(this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param
     * @return
     * @created_by tdcong
     * @date 5/17/2019
     */
    @Override
    public void showOnFail() {
        try {
            Toast.makeText(this, "Đăng nhập thất bại!", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * hàm lưu trạng thái
     *
     * @param
     * @return
     * @created_by tdcong
     * @date 5/17/2019
     */
    public void savingPreferences() {
        try {
            SharedPreferences pre = getSharedPreferences
                    (shfKey, MODE_PRIVATE);
            SharedPreferences.Editor editor = pre.edit();
            String user = etInputEmail.getText().toString();
            String pwd = etInputPassword.getText().toString();
            boolean bchk = cbSaveLogin.isChecked();
            if (!bchk) {
                editor.clear();
            } else {
                editor.putString("user", user);
                editor.putString("pwd", pwd);
                editor.putBoolean("checked", bchk);
            }
            editor.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * hàm đọc trạng thái đã lưu trước đó
     */
    public void restoringPreferences() {
        try {
            SharedPreferences pre = getSharedPreferences
                    (shfKey, MODE_PRIVATE);
            boolean bchk = pre.getBoolean("checked", false);
            if (bchk) {
                String user = pre.getString("user", "");
                String pwd = pre.getString("pwd", "");
                etInputEmail.setText(user);
                etInputPassword.setText(pwd);
            }
            cbSaveLogin.setChecked(bchk);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onResume() {
        try {
            super.onResume();
            restoringPreferences();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onPause() {
        try {
            super.onPause();
            savingPreferences();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
