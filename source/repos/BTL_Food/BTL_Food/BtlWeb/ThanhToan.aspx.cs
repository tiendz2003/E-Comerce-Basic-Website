using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace BTL_Food
{
    public partial class ThanhToan : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }
        protected void btnConfirm_Click(object sender, EventArgs e)
        {
            // Xử lý xác nhận thanh toán
            string name = txtName.Text;
            string address = txtAddress.Text;
            string phone = txtPhone.Text;

            // Kiểm tra dữ liệu và thực hiện các bước thanh toán
            // ...
        }
    }
}