<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Found Item Registration Form | Lost & Found</title>
    <link rel="stylesheet" href="found-form.css?v=1">
</head>

<body>
    <div class="navbar">
        <img src="L.png" alt="logo" width="80px">
        <ul>
            <li><button id="homeBtn-active">Home</button></li>
            <li><button id="SearchBtn" type="button">Search Item</button></li>
        </ul>
    </div>

    <h1>FOUND SOMETHING!!</h1>
    <P>Please Provide Details About Your Founding Item</P>

    <div class="information-submit">
        <div class="items-details">
            <form action="foundform" method="post" enctype="multipart/form-data">
                <div class="inputbox">
                    <label for="item-name">Item Name</label>
                    <input type="text" id="item-name" name="itemname" placeholder="Enter Item Name" required>
                </div>
                <div class="inputbox">
                    <label for="date">Found Date</label>
                    <input type="date" id="date" name="date" value="2025-10-26" required>
                </div>
                <div class="inputbox">
                    <label for="item-detail">Item Description</label>
                    <input type="text" id="item-detail" name="itemdetail"
                        placeholder="color, brand, unique feature, etc.." required>
                </div>
                <div class="inputbox">
                    <label for="time">Found Time</label>
                    <input type="time" id="time" name="time" value="14:05" required>
                </div>
                <div class="inputbox">
                    <label for="name">Your Name</label>
                    <input type="text" id="name" name="username" placeholder="Enetr Your Name" required>
                </div>
                <div class="inputbox">
                    <label for="phone-no">Phone-No</label>
                    <input type="number" id="phone-no" name="usernumber" placeholder="Enetr Your Phone-No">
                </div>

                <div class="image-item">
                    <label for="itemImage">Upload Item Image</label>
                    <div class="img-inputbox">
                        <img src="L2.png" alt="logo" width="100px" style="margin-left: 60px; ">
                        <input type="file" name="itemImage" accept="image/*">
                        <img id="preview" src="" alt="Image Preview" style="display:none;">
                    </div>
                </div>
                <div class="inputbox">
                    <label style="margin-bottom: 10px;">Item Type</label>
                    <div class="type-toggle">
                        <input type="radio" name="type" value="FOUND" id="found" checked>
                        <label for="found" class="found-label">FOUND</label>

                        <input type="radio" name="type" value="LOST" id="lost">
                        <label for="lost" class="lost-label">LOST</label>
                    </div>
                </div>
                <button type="submit">SUBMIT</button>
            </form>
        </div>
    </div>
 <script src="Script.js"></script>
</body>
</html>