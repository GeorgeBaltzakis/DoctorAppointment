function sendEmail() {
    Email.send({
        Host: "smtp.gmail.com",
        Username : "<sender’s email address>",
        Password : "<email password>",
        To : '<recipient’s email address>',
        From : "<sender’s email address>",
        Subject : "<email subject>",
        Body : "<email body>",
    }).then(
        message => alert("mail sent successfully")
    );
}
var vCode = null;
vCode = generateVerificationCode();
function sendVerificationCode(){
    Email.send({
        SecureToken : "b10ff7e7-4355-43b1-b87e-e68ab1b5a4f2",
        To : "george-baltzakis@hotmail.gr",
        From : "iasfaleia@gmail.com",
        Subject : "Verification Code, Doctor Appointment",
        Body : "Verification Code: " + generateVerificationCode(),
    }).then(
        message => alert("mail sent successfully")
    );
}
function generateVerificationCode() {
    const length = 6;
    let result = '';
    const characters = '0123456789';
    const charactersLength = characters.length;
    for (let i = 0; i < length; i++ ) {
        result += characters.charAt(Math.floor(Math.random() *
            charactersLength));
    }
    return result;
}
function checkVerificationCode(){
    const vCodeU = document.getElementById("vcode");
    return vCodeU === vCode;
}