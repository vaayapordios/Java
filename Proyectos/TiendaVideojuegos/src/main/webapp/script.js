
document.getElementById('loadFakeClientes').addEventListener('click', function(event) {
  event.preventDefault(); // Previene el comportamiento predeterminado de enviar el formulario

  // Obtén los valores del formulario
  const nombre = document.getElementById('nombre').value;
  const DNI = document.getElementById('DNI').value;
  const email = document.getElementById('email').value;
  const telefono = document.getElementById('telefono').value;

  // Crea un objeto con los datos del cliente
  const clienteData = {
      nombre: nombre,
      DNI: DNI,
      email: email,
      telefono: telefono
  };

  // Envía los datos del cliente al servidor o API
  fetch('https://my-json-serve.typicode.com/JuanCarlos27251/practicas', {
      method: 'POST',
      headers: {
          'Content-Type': 'application/json'
      },
      body: JSON.stringify(clienteData)
  })
  .then(response => {
      if (response.ok) {
          alert('Cliente registrado exitosamente!');
          // Aquí puedes hacer algo adicional, como limpiar el formulario o recargar la página
      } else {
          throw new Error('Error al registrar cliente');
      }
  })
  .catch(error => {
      console.error('Error:', error);
      alert('Hubo un error al registrar el cliente. Por favor, inténtalo de nuevo.');
  });
});

// Escucha el evento de envío del formulario de registro de libros
document.getElementById('loadFakeLibros').addEventListener('click', function(event) {
  event.preventDefault(); // Previene el comportamiento predeterminado de enviar el formulario

  // Obtén los valores del formulario
  const titulo = document.getElementById('titulo').value;
  const autor = document.getElementById('autor').value;
  const genero = document.getElementById('genero').value;
  const año_publicacion = document.getElementById('año_publicacion').value;

  // Crea un objeto con los datos del libro
  const libroData = {
      titulo: titulo,
      autor: autor,
      genero: genero,
      año_publicacion: año_publicacion
  };

  // Envía los datos del libro al servidor o API
  fetch('https://raw.githubusercontent.com/JuanCarlos27251/practicas/main/Libros.json', {
      method: 'POST',
      headers: {
          'Content-Type': 'application/json'
      },
      body: JSON.stringify(libroData)
  })
  .then(response => {
      if (response.ok) {
          alert('Libro registrado exitosamente!');
          // Aquí puedes hacer algo adicional, como limpiar el formulario o recargar la página
      } else {
          throw new Error('Error al registrar libro');
      }
  })
  .catch(error => {
      console.error('Error:', error);
      alert('Hubo un error al registrar el libro. Por favor, inténtalo de nuevo.');
  });
});
