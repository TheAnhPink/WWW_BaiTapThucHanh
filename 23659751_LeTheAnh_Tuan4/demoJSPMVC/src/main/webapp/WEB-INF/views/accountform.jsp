<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>User Registration Form</title>
    <link href="https://jsdelivr.net" rel="stylesheet">
    <style>
        body { background-color: #f8f9fa; }
        .registration-card { max-width: 500px; margin: 50px auto; background: #ffffff; padding: 30px; border-radius: 8px; border: 1px solid #dcdcdc; box-shadow: 0 4px 6px rgba(0, 0, 0, 0.05); }
        .form-title { text-align: center; font-weight: 500; margin-bottom: 25px; color: #212529; }
        .section-label { font-size: 0.95rem; color: #495057; margin-top: 15px; margin-bottom: 5px; font-weight: 500; }
        .btn-signup { background-color: #0d6efd; border: none; padding: 10px; font-size: 1.1rem; font-weight: 500; }
    </style>
</head>
<body>

<div class="container">
    <div class="registration-card">
        <h2 class="form-title">User Registration Form</h2>

        <form action="${pageContext.request.contextPath}/registerform" method="POST">

            <div class="row g-3 mb-3">
                <div class="col-6">
                    <input type="text" class="form-control" name="firstname" placeholder="First Name" required>
                </div>
                <div class="col-6">
                    <input type="text" class="form-control" name="lastname" placeholder="Last Name" required>
                </div>
            </div>

            <div class="mb-3">
                <input type="email" class="form-control" name="email" placeholder="Your Email" required>
            </div>

            <div class="mb-3">
                <input type="password" class="form-control" name="password" placeholder="Password" required>
            </div>

            <div class="section-label">Birthday</div>
            <div class="row g-2 mb-3">
                <div class="col-4">
                    <select class="form-select" name="birthMonth" required>
                        <option value="" disabled selected hidden>Month</option>
                        <option value="01">01</option>
                        <option value="02">02</option>
                        <option value="03">03</option>
                        <option value="04">04</option>
                        <option value="05">05</option>
                        <option value="06">06</option>
                        <option value="07">07</option>
                        <option value="08">08</option>
                        <option value="09">09</option>
                        <option value="10">10</option>
                        <option value="11">11</option>
                        <option value="12">12</option>
                    </select>
                </div>
                <div class="col-4">
                    <select class="form-select" name="birthDay" required>
                        <option value="" disabled selected hidden>Day</option>
                        <% for (int i = 1; i <= 31; i++) {
                            String dayStr = (i < 10) ? "0" + i : String.valueOf(i);
                        %>
                        <option value="<%= dayStr %>"><%= dayStr %></option>
                        <% } %>
                    </select>
                </div>
                <div class="col-4">
                    <select class="form-select" name="birthYear" required>
                        <option value="" disabled selected hidden>Year</option>
                        <% for (int i = 2026; i >= 1950; i--) { %>
                        <option value="<%= i %>"><%= i %></option>
                        <% } %>
                    </select>
                </div>
            </div>

            <div class="section-label">Gender</div>
            <div class="d-flex gap-3 mb-4">
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="gender" id="genderFemale" value="Female">
                    <label class="form-check-label" for="genderFemale">Female</label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="gender" id="genderMale" value="Male">
                    <label class="form-check-label" for="genderMale">Male</label>
                </div>
            </div>

            <div class="d-grid">
                <button type="submit" class="btn btn-primary btn-signup">Sign Up</button>
            </div>
        </form>
    </div>
</div>

</body>
</html>
