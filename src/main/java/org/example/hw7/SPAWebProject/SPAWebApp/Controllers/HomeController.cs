using Microsoft.AspNetCore.Mvc;
using SPAWebApplication.Models;

namespace SPAWebApplication.Controllers
{
    public class HomeController : Controller
    {
        public IActionResult Home()
        {
            return View();
        }

        public IActionResult Items()
        {
            return View();
        }

        public IActionResult Contact()
        {
            return View();
        }
    }
}
