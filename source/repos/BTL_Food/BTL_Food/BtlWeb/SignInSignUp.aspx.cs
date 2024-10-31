using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using BTL_Food.data;

namespace BTL_Food.BtlWeb
{
    public partial class SignInSignUp1 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }
        protected void SignIn(object sender, EventArgs e)
        {
            List<User> userlist = Application[Global.USER] as List<User>;

            if (IsPostBack)
            {
                foreach (User user in userlist)
                {
                    if (user.email != Request.Form.Get("login_account"))
                    {
                        KTdangnhap.InnerHtml = "Tài Khoản hoặc Mật Khẩu Không Chính Xác";
                    }
                    else
                    {
                        if (user.password != Request.Form.Get("login_password"))
                        {
                            KTdangnhap.InnerHtml = "Tài Khoản hoặc Mật Khẩu Không Chính Xác";
                        }
                        else
                        {
                            Session["User"] = user;
                            KTdangnhap.InnerHtml = "";
                            Response.Redirect("Home.aspx");
                            break;
                        }
                    }
                }
            }
        }

        protected void SignUp(object sender, EventArgs e)
        {
            List<User> userlist = Application[Global.USER] as List<User>;
            int kt = 0;
            if (IsPostBack)
            {
                foreach (User user in userlist)
                {
                    if (user.email == Request.Form.Get("register_email"))
                    {
                        KTDangky.InnerHtml = "Email đã tồn tai vui lòng chọn email khác";
                        kt = 1;
                    }
                }
                if (kt == 0)
                {
                    User newUser = new User();
                    newUser.email = Request.Form.Get("register_email");
                    newUser.nameAccount = Request.Form.Get("register_account");
                    newUser.password = Request.Form.Get("register_password");
                    userlist.Add(newUser);
                    Session["User"] = newUser;
                    Response.Redirect("Home.aspx");
                }
            }
        }
    }
}