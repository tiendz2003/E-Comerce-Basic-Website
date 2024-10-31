using System;
using System.Net.Mail;

namespace BTL_Food.BtlWeb
{
    public partial class Contact : System.Web.UI.Page
    {
        protected void btnSubmit_Click(object sender, EventArgs e)
        {
            string name = txtName.Text;
            string email = txtEmail.Text;
            string phone = txtPhone.Text;
            string message = txtMessage.Text;

            // Thực hiện gửi Email hoặc xử lý thông tin ở đây
            // Ví dụ: Gửi một email thông báo về thông tin liên hệ mới
            try
            {
                MailMessage mail = new MailMessage("youremail@example.com", "receiver@example.com");
                mail.Subject = "Thông Tin Liên Hệ Mới";
                mail.Body = $"Tên: {name}\nEmail: {email}\nSố điện thoại: {phone}\nTin nhắn: {message}";

                SmtpClient client = new SmtpClient
                {
                    Port = 587,
                    Host = "smtp.example.com", // Địa chỉ SMTP của bạn
                    EnableSsl = true,
                    Credentials = new System.Net.NetworkCredential("youremail@example.com", "password") // Thông tin đăng nhập của bạn
                };

                client.Send(mail);
                lblMessage.Text = "Cảm ơn bạn đã liên hệ với chúng tôi!";
                lblMessage.Visible = true;

                // Xóa thông tin trong biểu mẫu sau khi gửi
                txtName.Text = "";
                txtEmail.Text = "";
                txtPhone.Text = "";
                txtMessage.Text = "";
            }
            catch (Exception ex)
            {
                lblMessage.Text = "Có lỗi xảy ra. Vui lòng thử lại sau.";
                lblMessage.Visible = true;
            }
        }
    }
}