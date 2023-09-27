
$('document').ready(function(){
    $('.editButton').on('click', function(event){
        event.preventDefault();	

        var href = $(this).attr('href')
        $.get(href, function(client, status){
            $('#idEdit').val(client.id);
            $('#ddlCountryEdit').val(client.countryid);
            $('#ddlStateEdit').val(client.stateid);
            $('#addressEdit').val(client.address);
            $('#cityEdit').val(client.city);
            $('#detailsEdit').val(client.details);
            $('#emailEdit').val(client.email);
            $('#mobileEdit').val(client.mobile);
            $('#nameEdit').val(client.name);
            $('#phoneEdit').val(client.phone);
            $('#websiteEdit').val(client.website);
        })

        $('#editModal').modal()
    });

    $('.detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(client, status){
			$('#idDetails').val(client.id);
            $('#ddlCountryDetails').val(client.countryid);
            $('#ddlStateDetails').val(client.stateid);
            $('#addressDetails').val(client.address);
            $('#cityDetails').val(client.city);
            $('#detailsDetails').val(client.details);
            $('#emailDetails').val(client.email);
            $('#mobileDetails').val(client.mobile);
            $('#nameDetails').val(client.name);
            $('#phoneDetails').val(client.phone);
            $('#websiteDetails').val(client.website);
			$('#lastModifiedByDetails').val(client.lastModifiedBy);
			$('#lastModifiedDateDetails').val(client.lastModifiedDate.substr(0,19).replace("T", " "));
		});			
		$('#detailsModal').modal();		
	});	

    $('.deleteButton').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#delRef').attr('href', href);
		$('#deleteModal').modal();		
	});
});