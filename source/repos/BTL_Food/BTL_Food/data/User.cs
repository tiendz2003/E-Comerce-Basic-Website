using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace BTL_Food.data
{
    public class User
    {
        public string email { get; set; }
        public string nameAccount { get; set; }
        public string password { get; set; }
        public User() { }

        public User(string email, string nameAccount, string password)
        {
            this.email = email;
            this.nameAccount = nameAccount;
            this.password = password;
        }
    }
}