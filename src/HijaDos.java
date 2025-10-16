class LibroImpreso extends Libro {

    double peso;
    int Prestados;

    public LibroImpreso(String titulo, String autor, double precio, int cantidad, double peso, int Prestados) {
        super(titulo, autor, precio, cantidad);
        this.peso = peso;
        this.Prestados = Prestados;
    }

    @Override
    public void mostrarLibro() {
        super.mostrarLibro();
        int disponibles = cantidad - Prestados;
        System.out.println("Peso : " + peso + "Kg");
        System.out.println("Ejemplares Prestados: " + Prestados);
        System.out.println("Ejemplares DISPONIBLES para préstamo " + disponibles);
    }

    public boolean prestar (int cantidad) {
        int disponibles = cantidad - Prestados;

        if (cantidad <= 0 || cantidad > disponibles) {
            System.out.println("Solo hay " + disponibles + " ejemplares disponibles.");
            return false;
        }

        Prestados += cantidad;
        System.out.println("Préstamo de " + cantidad + " ejemplar exitoso.");
        return true;
    }

    public boolean devolver(int cantidad) {
        if (cantidad > 2) {
            System.out.println("solo se pueden devolver máximo 2 libros a la vez.");
            return false;
        }

        if (cantidad <= 0 || cantidad > Prestados) {
            System.out.println("Cantidad a devolver inválida o no tienes tantos prestados.");
            return false;
        }

        Prestados -= cantidad;
        System.out.println("Devolución de " + cantidad );
        return true;
    }
}