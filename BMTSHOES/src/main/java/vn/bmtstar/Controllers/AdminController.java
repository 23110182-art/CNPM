package vn.bmtstar.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/admin/dashboard")
    public String dashboard(Model model) {
        // Dữ liệu demo (sau này sẽ lấy từ service)
        model.addAttribute("totalRevenue", 12500000);
        model.addAttribute("newOrders", 34);
        model.addAttribute("bestSeller", "Nike Air Max 270");
        model.addAttribute("newUsers", 12);

        return "admin/dashboard"; // trỏ tới templates/admin/dashboard.html
    }
}

