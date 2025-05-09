# Order Processor - Spring Boot Project

## Project Overview

This is a Spring Boot project that processes order data provided in JSON format. It calculates the total cost and item count for each order and provides a summary of shipped orders and revenue. A simple web interface allows users to upload order data and view the results in a clean, user-friendly format.

## Features

- **Order Processing**: Calculate the total cost and item count for each order.
- **Order Summary**: Display the total number of shipped orders and the total revenue from shipped orders.
- **User Interface**: An easy-to-use HTML interface to input JSON data and display processed results.

## Technologies Used

- **Backend**: Java, Spring Boot, Spring MVC
- **Frontend**: HTML, CSS, JavaScript
- **Tools**: IntelliJ IDEA, Maven


## Steps to Run

1. **Clone the Repository**:  
   If you haven't already cloned the repository, use the following command:

   ```bash
   git clone https://github.com/your-repository-url.git  
   cd order-processor  
   ```

2. **Build the Project**:
    - Open the project in IntelliJ IDEA or your favorite IDE.
    - Use the following command to build the project:

   ```bash
   mvn clean install  
   ```

3. **Run the Application**:
    - You can run the application by executing the following command in your terminal:

   ```bash
   mvn spring-boot:run  
   ```

   Or, you can run the `OrderProcessorApplication.java` file directly from your IDE.

4. **Access the Web Interface**:
    - Open your browser and go to `http://localhost:8080` to access the order processor interface.
    - Paste your JSON order data into the input field and click the "Process Orders" button to see the processed results.

## How It Works

### Backend (Spring Boot):
- The backend exposes an API endpoint at `/api/orders/process` to handle POST requests with the order data.
- The data is processed to calculate the total cost and item count for each order.
- A summary of shipped orders and revenue is generated and returned in the response.

### Frontend (HTML & JavaScript):
- The frontend contains a simple form to accept JSON input, which is sent to the backend for processing.
- After processing, the results are dynamically displayed on the page using JavaScript.

## Endpoints

### POST `/api/orders/process`
- **Request Body**: A JSON array representing the list of orders to process.
- **Response**: A JSON object containing the processed orders with their total cost, item count, and a summary of shipped orders.

### Example Request

```json
[
   {
      "orderId": "1001",
      "customer": "Alice",
      "items": [
         {"product": "Widget", "quantity": 2, "price": 10.0},
         {"product": "Gadget", "quantity": 1, "price": 15.0}
      ],
      "status": "shipped"
   },
   {
      "orderId": "1002",
      "customer": "Bob",
      "items": [
         {"product": "Widget", "quantity": 1, "price": 10.0}
      ],
      "status": "pending"
   }
]
```

### Example Response

```json
{
   "orders": [
      {
         "itemCount": 3,
         "totalCost": 35,
         "orderId": "1001",
         "customer": "Alice",
         "items": [
            {"product": "Widget", "quantity": 2, "price": 10.0},
            {"product": "Gadget", "quantity": 1, "price": 15.0}
         ],
         "status": "shipped"
      },
      {
         "itemCount": 1,
         "totalCost": 10,
         "orderId": "1002",
         "customer": "Bob",
         "items": [
            {"product": "Widget", "quantity": 1, "price": 10.0}
         ],
         "status": "pending"
      }
   ],
   "summary": {
      "totalShippedOrders": 1,
      "totalRevenue": 35
   }
}
```

## Troubleshooting

### Error Processing Orders:
- If there is an issue processing the orders, ensure that the JSON format is correct. You can check for common issues such as missing or extra commas, mismatched brackets, or incorrect data types.

### UI Not Displaying Results:
- If the results are not displaying, check the console for JavaScript errors or network issues. Ensure the backend server is running and accessible at `http://localhost:8080`.




