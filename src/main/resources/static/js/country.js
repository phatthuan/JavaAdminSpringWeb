
$('document').ready(function(){
    $('.editButton').on('click', function(event){
        event.preventDefault();	

        var href = $(this).attr('href')
        $.get(href, function(country, status){
            $('#idEdit').val(country.id)
            $('#descriptionEdit').val(country.description)
            $('#capitalEdit').val(country.capital)
            $('#txtCodeEdit').val(country.code)
            $('#continentEdit').val(country.continent)
            $('#nationalityEdit').val(country.nationality)
        })

        $('#editModal').modal()
    });

    $('.detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(country, status){
			$('#idDetails').val(country.id)
            $('#descriptionDetails').val(country.description)
            $('#capitalDetails').val(country.capital)
            $('#txtCodeDetails').val(country.code)
            $('#continentDetails').val(country.continent)
            $('#nationalityDetails').val(country.nationality)
			$('#lastModifiedByDetails').val(country.lastModifiedBy);
			$('#lastModifiedDateDetails').val(country.lastModifiedDate.substr(0,19).replace("T", " "));
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