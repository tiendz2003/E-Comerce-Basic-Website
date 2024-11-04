using BTL_Food.data;
using BTL_Food.MasterPage;
using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace BTL_Food.BtlWeb
{
    public partial class QLMH : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            List<Product> list = Application[Global.PRODUCT] as List<Product>;
            Product product = new Product( );
            //try (!string.IsNullOrEmpty(Request.Form["SL"]) || !string.IsNullOrEmpty(Request.Form["Price"])  || !string.IsNullOrEmpty(Request.Form["TenMH"]))


            try
            {
                if (string.IsNullOrEmpty(Request.Form["TenMH"]))
                {
                    throw new Exception("TenMH trống");
                }
                product.id = list.Count+1;
                product.name = Request.Form["TenMH"];
                product.Quantity = int.Parse(Request.Form["SL"]);
                product.productPrice = decimal.Parse(Request.Form["Price"]);
                product.mota = Request.Form["mota"];

                FileUpload.SaveAs(Server.MapPath("~/img/") + FileUpload.FileName);
                product.imageUrl = "img/" + FileUpload.FileName;
                list.Add(product);

        }
            catch (Exception ex)
            {
                alert("xin hãy điền dầy đủ thông tin của mặt hàng");
    }


}
        private void alert(string message)
        {
            string alert = "";
            alert += "<script>alert('"+message+"');</script>";
            Response.Write(alert);
        }
        
    }
}