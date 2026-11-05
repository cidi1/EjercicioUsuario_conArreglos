void main(String[] args) {
    final int MAX = 3;
    Usuario usuarios[] = new Usuario[MAX];
    Scanner sc = new Scanner(System.in);
    boolean lleno = false;
    int opc;

    do {
        System.out.println("\n--- USUARIOS ---");
        System.out.println("1. Llenar todo el arreglo");
        System.out.println("2. Mostrar todos los usuarios");
        System.out.println("3. Probar validación de contraseña en todos");
        System.out.println("0. Salir");
        System.out.print("Opción: ");
        opc = Integer.parseInt(sc.nextLine());
        switch (opc) {
            case 1:
                for (int i = 0; i < usuarios.length; i++) {
                    System.out.print("Nombre de usuario: ");
                    String nombre = sc.nextLine();
                    System.out.print("Correo: ");
                    String correo = sc.nextLine();
                    usuarios[i] = new Usuario(nombre, correo);
                    do {
                        System.out.print("Contraseña (mínimo 8 caracteres): ");
                        usuarios[i].setContrasena(sc.nextLine());
                    } while (usuarios[i].getContrasena().length() < 8);
                }
                lleno = true;
                break;
            case 2:
                if (lleno) {
                    for (int i = 0; i < usuarios.length; i++) {
                        usuarios[i].mostrarDatos();
                    }
                } else System.out.println("Primero llene el arreglo.");
                break;
            case 3:
                if (lleno) {
                    for (int i = 0; i < usuarios.length; i++) {
                        System.out.print("Nueva contraseña para " + usuarios[i].getNombreUsuario() + ": ");
                        usuarios[i].setContrasena(sc.nextLine());
                    }
                } else System.out.println("Primero llene el arreglo.");
                break;
            case 0: System.out.println("Fin del programa."); break;
            default: System.out.println("Opción inválida.");
        }
    } while (opc != 0);
}