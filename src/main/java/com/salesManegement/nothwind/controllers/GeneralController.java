package com.salesManegement.nothwind.controllers;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.opencsv.CSVWriter;
import com.salesManegement.nothwind.models.Customer;
import com.salesManegement.nothwind.models.Order;
import com.salesManegement.nothwind.models.OrderDetails;
import com.salesManegement.nothwind.models.Product;
import com.salesManegement.nothwind.repository.CustomerRepository;
import com.salesManegement.nothwind.repository.OrderDetailsRepository;
import com.salesManegement.nothwind.repository.OrderRepository;
import com.salesManegement.nothwind.repository.ProductRepository;
import com.salesManegement.nothwind.repository.ProductService;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Controller
public class GeneralController {
    
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderDetailsRepository orderDetailsRepository;
    @Autowired
    private ProductService service;


    @GetMapping("/")
    public ModelAndView index() {
        return showListCustomer(0);
    }

    @PostMapping("/addNewCustomer")
    public String costumerRegistration(@ModelAttribute Customer customer) {
        try {
            this.customerRepository.save(customer);
        } catch (Exception e) {
            System.out.println(e);
        }
        return "redirect:/listCustomers";
    }

    @GetMapping("/addCustomer")
    public String showAddCustomerPage() {
        return "addCustomer";
    }

    @PostMapping("/addNewOrder")
    public String orderRegistration(@ModelAttribute Order order, @RequestParam("productComboBox") String productID) {
        System.out.println(order);
        this.orderRepository.save(order);
        // this.orderDetailsRepository.save(new OrderDetails(Integer.parseInt(productID)));
        return "redirect:/listOrders";
    }

    @PostMapping("/addNewProduct")
    public String productRegistration(@ModelAttribute Product product) {
        this.productRepository.save(product);
        System.out.println(product);
        return "redirect:/listProducts";
    }

    @GetMapping("/addProduct")
    public String showAddProductPage() {
        return "addProduct";
    }

    @RequestMapping("/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable("id") String id) {
            customerRepository.deleteById(id);
        return "redirect:/listCustomers";
    }

    @PostMapping("customerDetails/updateCustomer")
    public String updateCustomer(@ModelAttribute Customer customer) {
        if (this.customerRepository.findById(customer.getCustomerID()).isPresent()) {
            this.customerRepository.deleteById(customer.getCustomerID());
        }
        this.customerRepository.save(customer);
        System.out.println(customer);
        return "redirect:/listCustomers";
    }

    // PARTE DA LISTA:

    @GetMapping("/addOrder")
    public ModelAndView showAddOrderPage(@RequestParam(defaultValue = "0") int page) {
        int pageSize = 10;
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Product> productPage = productRepository.findAll(pageable);
        ModelAndView mv = new ModelAndView("addOrder");
        mv.addObject("products", productPage.getContent());
        return mv;
    }

    @GetMapping("/listProducts")
    public ModelAndView showListProduct(@RequestParam(defaultValue = "0") int page) {
        int pageSize = 10;
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Product> productPage = productRepository.findAll(pageable);
        ModelAndView mv = new ModelAndView("listProducts");
        mv.addObject("allProducts", productPage.getContent());
        mv.addObject("currentPage", productPage.getNumber());
        mv.addObject("totalPages", productPage.getTotalPages());
        return mv;
    }

    @GetMapping("/listCustomers")
    public ModelAndView showListCustomer(@RequestParam(defaultValue = "0") int page) {
        int pageSize = 10;
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Customer> customerPage = customerRepository.findAll(pageable);
        ModelAndView mv = new ModelAndView("listCustomers");
        mv.addObject("allCustomers", customerPage.getContent());
        mv.addObject("currentPage", customerPage.getNumber());
        mv.addObject("totalPages", customerPage.getTotalPages());
        return mv;
    }

    @GetMapping("/listOrders")
    public ModelAndView showListOrder(@RequestParam(defaultValue = "0") int page) {
        int pageSize = 10;
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Order> ordersPage = orderRepository.findAll(pageable);
        ModelAndView mv = new ModelAndView("listOrders");
        mv.addObject("allOrders", ordersPage != null ? ordersPage.getContent() : Collections.emptyList());
        mv.addObject("currentPage", ordersPage.getNumber());
        mv.addObject("totalPages", ordersPage.getTotalPages());
        return mv;
    }

    @GetMapping("/customerDetails/{id}")
    public ModelAndView customerDetails(@PathVariable("id") String id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        ModelAndView mv = new ModelAndView("detailsCustomers");

        if(!(optionalCustomer.isPresent())){
            throw new NoSuchElementException("Customer not Found");
        }

        mv.addObject("customers", optionalCustomer.get());
        return mv;
    }

    // PARTE DO PROCEDIMENTO ARMAZENADO:

    @GetMapping("/products/csv")
    public void exportProductsToCsv(HttpServletResponse response) throws IOException {

        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=\"products.csv\"");

        List<Product> products  = service.ObterProdutosMaisCaros();

        CSVWriter csvWriter = new CSVWriter(new OutputStreamWriter(response.getOutputStream(), StandardCharsets.UTF_8));
        csvWriter.writeNext(new String[]{"ID", "Name", "Price"});

        for (Product product : products) {
            csvWriter.writeNext(new String[]{String.valueOf(product.getProductID()), product.getProductName(), String.valueOf(product.getUnitPrice()), String.valueOf(product.getDiscontinued())});
        }

        csvWriter.close();

    }
}