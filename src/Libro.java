class Libro {
    String titulo;
    String autor;
    double precio;
    int cantidad;

    public Libro(String titulo, String autor, double precio, int cantidad) {
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public void mostrarLibro() {
        System.out.println("LIBRERIA");
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Precio: $" + precio);
        System.out.println("Ejemplares Totales: " + cantidad);

    }
}