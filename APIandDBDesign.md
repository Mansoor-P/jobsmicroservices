
## API Endpoints

### Company Endpoints

- **Create Company:**
  ```http
  POST /api/v1/companies
  ```
  **Request Body:**
  ```json
  {
    "name": "Company Name",
    "address": "Company Address",
    "email": "company@example.com"
  }
  ```
  **Response:**
  ```json
  {
    "id": 1,
    "name": "Company Name",
    "address": "Company Address",
    "email": "company@example.com"
  }
  ```

- **Get All Companies:**
  ```http
  GET /api/v1/companies
  ```
  **Response:**
  ```json
  [
    {
      "id": 1,
      "name": "Company Name",
      "address": "Company Address",
      "email": "company@example.com"
    }
  ]
  ```

- **Get Company by ID:**
  ```http
  GET /api/v1/companies/{companyId}
  ```
  **Response:**
  ```json
  {
    "id": 1,
    "name": "Company Name",
    "address": "Company Address",
    "email": "company@example.com"
  }
  ```

- **Update Company:**
  ```http
  PUT /api/v1/companies/{companyId}
  ```
  **Request Body:**
  ```json
  {
    "name": "Updated Company Name",
    "address": "Updated Company Address",
    "email": "updated@example.com"
  }
  ```
  **Response:**
  ```json
  {
    "id": 1,
    "name": "Updated Company Name",
    "address": "Updated Company Address",
    "email": "updated@example.com"
  }
  ```

- **Delete Company:**
  ```http
  DELETE /api/v1/companies/{companyId}
  ```
  **Response:**
  ```json
  {
    "message": "Company deleted successfully."
  }
  ```

### Job Endpoints

- **Create Job:**
  ```http
  POST /api/v1/companies/{companyId}/jobs
  ```
  **Request Body:**
  ```json
  {
    "title": "Job Title",
    "description": "Job Description",
    "location": "Job Location",
    "salary": 60000
  }
  ```
  **Response:**
  ```json
  {
    "id": 1,
    "title": "Job Title",
    "description": "Job Description",
    "location": "Job Location",
    "salary": 60000,
    "companyId": 1
  }
  ```

- **Get All Jobs for a Company:**
  ```http
  GET /api/v1/companies/{companyId}/jobs
  ```
  **Response:**
  ```json
  [
    {
      "id": 1,
      "title": "Job Title",
      "description": "Job Description",
      "location": "Job Location",
      "salary": 60000,
      "companyId": 1
    }
  ]
  ```

- **Get Job by ID:**
  ```http
  GET /api/v1/jobs/{jobId}
  ```
  **Response:**
  ```json
  {
    "id": 1,
    "title": "Job Title",
    "description": "Job Description",
    "location": "Job Location",
    "salary": 60000,
    "companyId": 1
  }
  ```

- **Update Job:**
  ```http
  PUT /api/v1/jobs/{jobId}
  ```
  **Request Body:**
  ```json
  {
    "title": "Updated Job Title",
    "description": "Updated Job Description",
    "location": "Updated Job Location",
    "salary": 65000
  }
  ```
  **Response:**
  ```json
  {
    "id": 1,
    "title": "Updated Job Title",
    "description": "Updated Job Description",
    "location": "Updated Job Location",
    "salary": 65000,
    "companyId": 1
  }
  ```

- **Delete Job:**
  ```http
  DELETE /api/v1/jobs/{jobId}
  ```
  **Response:**
  ```json
  {
    "message": "Job deleted successfully."
  }
  ```

### Review Endpoints

- **Create Review:**
  ```http
  POST /api/v1/companies/{companyId}/reviews
  ```
  **Request Body:**
  ```json
  {
    "rating": 5,
    "comment": "Great company to work for!"
  }
  ```
  **Response:**
  ```json
  {
    "id": 1,
    "rating": 5,
    "comment": "Great company to work for!",
    "companyId": 1
  }
  ```

- **Get All Reviews for a Company:**
  ```http
  GET /api/v1/companies/{companyId}/reviews
  ```
  **Response:**
  ```json
  [
    {
      "id": 1,
      "rating": 5,
      "comment": "Great company to work for!",
      "companyId": 1
    }
  ]
  ```

- **Get Review by ID:**
  ```http
  GET /api/v1/reviews/{reviewId}
  ```
  **Response:**
  ```json
  {
    "id": 1,
    "rating": 5,
    "comment": "Great company to work for!",
    "companyId": 1
  }
  ```

- **Update Review:**
  ```http
  PUT /api/v1/reviews/{reviewId}
  ```
  **Request Body:**
  ```json
  {
    "rating": 4,
    "comment": "Good company to work for."
  }
  ```
  **Response:**
  ```json
  {
    "id": 1,
    "rating": 4,
    "comment": "Good company to work for.",
    "companyId": 1
  }
  ```

- **Delete Review:**
  ```http
  DELETE /api/v1/reviews/{reviewId}
  ```
  **Response:**
  ```json
  {
    "message": "Review deleted successfully."
  }
  ```

## Database Schema

### Companies Table

| Field         | Type    | Description                  |
|---------------|---------|------------------------------|
| id            | Long    | Unique identifier            |
| name          | String  | Name of the company          |
| address       | String  | Address of the company       |
| email         | String  | Contact email of the company |



### Jobs Table
| Field         | Type    | Description                  |
|---------------|---------|------------------------------|
| id            | Long    | Unique identifier            |
| title         | String  | Job title                    |
| description   | String  | Job description              |
| location      | String  | Job location                 |
| salary        | Long    | Salary for the job           |
| companyId     | Long    | Foreign key to company table |

### Reviews Table
| Field         | Type    | Description                  |
|---------------|---------|------------------------------|
| id            | Long    | Unique identifier            |
| rating        | Integer | Rating given                 |
| comment       | String  | Review comment               |
| companyId     | Long    | Foreign key to company table |