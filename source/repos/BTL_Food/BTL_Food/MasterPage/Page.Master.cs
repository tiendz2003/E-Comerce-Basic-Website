using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using BTL_Food.data;

namespace BTL_Food.MasterPage
{
    public partial class Page : System.Web.UI.MasterPage
    {

        protected void Page_Load(object sender, EventArgs e)
        {
            User user = Session["User"] as User;
            if (!IsPostBack)
            {
                if (user != null && user.nameAccount != null) // Kiểm tra user khác null
                {
                   
                    btnSignUp.Text = user.nameAccount;
                    btnSignIn.Text = "Đăng xuất";
                }
            }
        }
        protected void SearchInfor(object sender, EventArgs e)
            {
                string searchValue = inputSearch.Text;

                // Lưu giá trị tìm kiếm vào Session
                Session["Search"] = searchValue;
                Response.Redirect("Search.aspx");
            }
            protected void signUp(object sender, EventArgs e)
            {
                if (btnSignUp.Text == "Đăng Ký")
                {
                    Response.Redirect("SignInSignUp.aspx?name=DangKy");
                }
            }

            protected void signIn(object sender, EventArgs e)
            {
                if (btnSignIn.Text == "Đăng Nhập")
                {
                    Response.Redirect("SignInSignUp.aspx?name=DangNhap");
                }
                else
                {
                    //dang xuat
                    Session["User"] = new User();
                    Response.Redirect("Home.aspx");

                }
            }
    }
}