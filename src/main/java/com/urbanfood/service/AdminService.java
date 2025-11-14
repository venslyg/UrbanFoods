package com.urbanfood.service;

import com.urbanfood.entity.Admin;
import com.urbanfood.entity.Customer;
import com.urbanfood.entity.Supplier;
import com.urbanfood.repository.AdminRepository;
import com.urbanfood.repository.CustomerRepository;
import com.urbanfood.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private final AdminRepository adminRepository;
    private final CustomerRepository customerRepository;
    private final SupplierRepository supplierRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository, CustomerRepository customerRepository, SupplierRepository supplierRepository) {
        this.adminRepository = adminRepository;
        this.customerRepository = customerRepository;
        this.supplierRepository = supplierRepository;
    }

    // Create or Update Admin
    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    // Delete Admin
    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }

    // Admin Login
    public boolean loginAdmin(String username, String password) {
        Admin admin = adminRepository.findByEmail(username);
        if (admin != null && admin.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    // Create or Update Customer
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // Delete Customer
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    // Create or Update Supplier
    public Supplier saveSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    // Delete Supplier
    public void deleteSupplier(Long id) {
        supplierRepository.deleteById(id);
    }
}
