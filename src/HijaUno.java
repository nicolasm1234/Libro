class LibroDigital extends Libro {
    double tamanio;
    boolean disponible;

    public LibroDigital(String titulo, String autor, double precio, int cantidad, double tamanio, boolean disponible) {
        super(titulo, autor, precio, cantidad);
        this.tamanio = tamanio;
        this.disponible = disponible;
    }

    @Override
    public void mostrarLibro() {

        super.mostrarLibro();
        System.out.println("Tamanio " + tamanio);
        System.out.println("Disponibles " + cantidad);
        System.out.println("Disponibilidad General " + (disponible ? "SÍ" : "NO"));
    }

    public void devolver() {
        if (disponible) {
             this.disponible = true;
            System.out.println("Libro digital ahora disponible");
        } else {
            System.out.println("El libro digital ya estaba disponible");
        }
    }

    public boolean prestar(int cantidad) {
        if (disponible) {
            System.out.println("Licencia general no activa");
            return false;
        }
        if (cantidad > this.cantidad) {
            System.out.println("Solo quedan " + this.cantidad+ " licencia");
            return false;
        }

        this.cantidad = cantidad;
        System.out.println("Se prestó" + cantidad + "Restantes " + this.cantidad);
        return true;
    }
}
