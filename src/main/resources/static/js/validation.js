$(function () {
    $('#loginForm').validate({

        rules:{
            loginEmail: {
                required: true,
                email: true
            },

            loginPassword:{
                required: true
            }
        },
        messages:{
            loginEmail:{
                required: 'Email is Required to Sign in.',
                email: 'Please enter a <em>valid</em> email.'
            },
            loginPassword:{
                required: 'Password is also Required to Sign in.'
            }
        }

    })
})