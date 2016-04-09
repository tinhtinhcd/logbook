function validate(){
    var name = document.getElementById("name").value;
    var start = document.getElementById("date_event").value;
    var date = document.getElementById("start_time").value;
    var loc = document.getElementById("loc").value;
    var org = document.getElementById("org").value;

    var invalid = "";

    if(name.length <= 0)
        invalid += "Please enter event name!";
    else if(start.length <= 0)
        invalid += "Please enter start date!";
    else if(org.length <= 0)
        invalid += "Please enter organizer!";
    else if(invalid == "")
       invalid = "valid data";

    alert(invalid);
}



