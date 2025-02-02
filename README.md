# AllInOneFlightBooking - Seamless Flight Reservation System

## ✈️ Overview
AllInOneFlightBooking is a **comprehensive flight reservation system** designed to provide users with a seamless booking experience. The platform enables users to **search, compare, and book flights** efficiently. It supports **user authentication, flight details management, booking history tracking, and secure payment integration**. Users can filter flights by destination, departure date, and class preferences, along with customer support options for cancellations and modifications.

## 🚀 Tech Stack
### **Backend:**
- **Spring Boot (Java)** - Backend framework for RESTful APIs
- **MySQL** - Relational database for storing flight, user, and booking details
- **Spring Security** - User authentication and role-based access control
- **JPA/Hibernate** - ORM for database operations

### **Frontend:**
- **React.js** - User-friendly and interactive frontend
- **Redux** - State management for efficient data flow
- **Axios** - API calls to backend services
- **Bootstrap/Tailwind CSS** - Responsive UI design

### **Other Tools & Services:**
- **Postman** - API testing
- **Swagger** - API documentation
- **Git & GitHub** - Version control and collaboration
- **Docker (Optional)** - Containerization for deployment

## 📌 Features
- **User Authentication:** Secure login & registration (Admin & Customer roles)
- **Flight Search & Filtering:** Find flights by destination, departure time, and class
- **Flight Booking & Payment:** Secure reservations and online payments
- **Booking Management:** View, modify, or cancel bookings
- **Admin Dashboard:** Manage flights, bookings, and users
- **Reviews & Ratings:** Users can review airlines and rate their experiences
- **Nearest Airport Lookup:** Find nearby airports based on location

## 🏗️ Project Structure
```
AllInOneFlightBooking/
├── backend/  # Spring Boot application
│   ├── src/main/java/com/flightbooking/
│   │   ├── controller/   # REST controllers
│   │   ├── service/      # Business logic
│   │   ├── repository/   # Database operations
│   │   ├── model/        # Entity classes
│   │   ├── config/       # Security & configurations
│   ├── src/main/resources/
│   │   ├── application.properties  # Database and server config
│   ├── pom.xml  # Dependencies
├── frontend/  # React.js application
│   ├── src/
│   │   ├── components/  # UI Components
│   │   ├── pages/       # Pages (Home, Booking, Admin, etc.)
│   │   ├── redux/       # State management
│   │   ├── services/    # API calls
│   ├── package.json  # Frontend dependencies
│   ├── public/
├── README.md  # Project documentation
└── .gitignore  # Ignored files
```

## 🔧 Installation & Setup
### **1. Clone the Repository**
```bash
git clone https://github.com/your-username/AllInOneFlightBooking.git
cd AllInOneFlightBooking
```

### **2. Backend Setup (Spring Boot)**
```bash
cd backend
mvn clean install
mvn spring-boot:run
```
- Configure **application.properties** with MySQL database details.

### **3. Frontend Setup (React.js)**
```bash
cd frontend
npm install
npm start
```
- Ensure the backend is running before starting the frontend.

## 📌 API Endpoints
### **User Management**
- `POST /api/auth/register` - User Registration
- `POST /api/auth/login` - User Login

### **Flight Management**
- `GET /api/flights` - Get all flights
- `POST /api/flights` - Add new flight (Admin only)

### **Booking & Payment**
- `POST /api/bookings` - Book a flight
- `GET /api/bookings/{id}` - Get booking details
- `POST /api/payments` - Process payment

📜 **Full API documentation available in Swagger** (`/swagger-ui.html`)

## 🚀 Deployment
To deploy using **Docker**:
```bash
docker-compose up --build
```
For manual deployment, configure **Spring Boot** on a cloud server and host the **React.js frontend** on a service like **Vercel or Netlify**.

## 👨‍💻 Contributors
- **[Your Name]** - Full Stack Developer
- **[Other Team Members]** (If applicable)

## 📄 License
This project is open-source under the **MIT License**.

---
💡 *Feel free to contribute! Fork the repo and submit pull requests.*

