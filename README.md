
# API Implementation - User Data and Image Upload

This project implements an API that allows users to upload an image file along with user data using the `form-data` format. The API endpoint is designed to handle the following parameters:

- **Request Type:** POST
- **Endpoint:** `/create`

## Request Parameters

1. **file:** The image file to be uploaded.
2. **user:** A JSON string representing user data.

### Example Request:

http
POST /api/users/create
Content-Type: multipart/form-data

file: [select image file]
user: {"name": "John Doe", "email": "johndoe@example.com", "mobile": "1234567890"}

### Example Response

The API response provides the created user's details, including the generated id, mail, name, mobile, and the profile image filename.

```{
    "id": 2,
    "mail": "nk2@gmail.com",
    "name": "harshg",
    "mobile": "8799093636",
    "profile": "1692190585052.jpg"
}
```

## To get all users


- **Request Type:** GET
- **Endpoint:** `/get-user`

  This will return the list of all users
