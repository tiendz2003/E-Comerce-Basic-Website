using BTL_Food.data;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace BTL_Food.BtlWeb
{
    public partial class QLTK : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            List<User> list = Application[Global.USER] as List<User>;
            User user = new User();
            if (!string.IsNullOrEmpty(Request.Form["email"]) || !string.IsNullOrEmpty(Request.Form["acc-name"]) || !string.IsNullOrEmpty(Request.Form["pass"]))
            {
                user.email = Request.Form["email"];
                user.nameAccount = Request.Form["acc-name"];
                user.password = (Request.Form["pass"]);
                list.Add(user);
            }
            
            
           
        }
    }
}