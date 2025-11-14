package com.urbanfood.controller;

import com.urbanfood.entity.Admin;
import com.urbanfood.entity.Customer;
import com.urbanfood.entity.Supplier;
import com.urbanfood.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    // Create or Update Admin
    @PostMapping
    public Admin createOrUpdateAdmin(@RequestBody Admin admin) {
        return adminService.saveAdmin(admin);
    }

    // Delete Admin
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
        return ResponseEntity.ok("Admin deleted successfully");
    }

    // Login Admin
    @PostMapping("/login")
    public ResponseEntity<String> loginAdmin(@RequestParam String username, @RequestParam String password) {
        boolean isAuthenticated = adminService.loginAdmin(username, password);
        if (isAuthenticated) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }

    // Create or Update Customer
    @PostMapping("/customers")
    public Customer createOrUpdateCustomer(@RequestBody Customer customer) {
        return adminService.saveCustomer(customer);
    }

    // Delete Customer
    @DeleteMapping("/customers/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
        adminService.deleteCustomer(id);
        return ResponseEntity.ok("Customer deleted successfully");
    }

    // Create or Update Supplier
    @PostMapping("/suppliers")
    public Supplier createOrUpdateSupplier(@RequestBody Supplier supplier) {
        return adminService.saveSupplier(supplier);
    }

    // Delete Supplier
    @DeleteMapping("/suppliers/{id}")
    public ResponseEntity<String> deleteSupplier(@PathVariable Long id) {
        adminService.deleteSupplier(id);
        return ResponseEntity.ok("Supplier deleted successfully");
    }
}
