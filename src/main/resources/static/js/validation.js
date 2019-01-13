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
$(function(){
	
	$.validator.addMethod('strongPassword',function(value, element){
		return this.optional(element)
		|| value.length >= 6
		&& /\d/.test(value)
		&& /[a-z]/i.test(value);
	},'Your password must be at least 6 characters long and contain at least one number.')
	
	$("createAccountForm").validate({
		rules:{
			signUpEmail:{
				required:true,
				email:true
			
				
			},
			signUpPassword:{
				required:true,
				strongPassword:true
			},
			signUpConfirmPassword:{
				required:true,
				equalTo: "#signUpPassword"
			}
	
		},
		messages:{
			signUpEmail:{
				required:'Please enter an email address.',
				email: 'Please enter a <em>valid</em> email'
				
			}
		}
	})
})