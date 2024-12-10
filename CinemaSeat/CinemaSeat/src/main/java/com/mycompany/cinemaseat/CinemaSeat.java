package com.mycompany.cinemaseat;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
import com.mycompany.cinemaseat.clases.*;
import com.mycompany.cinemaseat.strategy.*;
import com.mycompany.cinemaseat.chainofresponsibility.*;
import com.mycompany.cinemaseat.observer.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CinemaSeat {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Crear usuarios
        Usuario usuario1 = new Usuario("Juan Perez", "juan@mail.com", "cliente");
        Usuario usuario2 = new Usuario("Maria Lopez", "maria@mail.com", "cliente");
        Administrador admin = new Administrador("Admin", "admin@cineplex.com", "administrador");

        // Crear cine
        Cine cine = new Cine("Cineplex", "Centro Comercial");

        // Crear tipos de asientos (4D, VIP, Estándar)
        Asiento asiento1 = new Asiento(1, new Asiento_4D(new ArrayList<>(Arrays.asList("Viento", "Agua"))));
        Asiento asiento2 = new Asiento(2, new Asiento_VIP(1.5, "Lujoso"));
        Asiento asiento3 = new Asiento(3, new Asiento_Estandar());
        Asiento asiento4 = new Asiento(4, new Asiento_4D(new ArrayList<>(Arrays.asList("Luz", "Viento"))));

        // Crear una sala y agregar asientos
        Sala sala1 = new Sala(1, "Estándar");
        sala1.agregarAsiento(asiento1);
        sala1.agregarAsiento(asiento2);
        sala1.agregarAsiento(asiento3);
        sala1.agregarAsiento(asiento4);
        cine.agregarSala(sala1);

        // Crear una función y agregarla a la sala
        Funcion funcion1 = new Funcion(LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(2));
        sala1.agregarFuncion(funcion1);

        // Creación del objeto manejador de reportes y notificaciones
        ManejadorReporte soporte = new AgenteSoporte();
        ManejadorReporte admini = new AdministradorReporte();
        soporte.setSiguiente(admini);

        GestorNotificaciones gestor = new GestorNotificaciones();

        boolean volverAlInicio;
        do {
            volverAlInicio = false; // Controla si se debe volver a pedir el usuario

            // Login del usuario
            Usuario usuarioSeleccionado = null;
            while (usuarioSeleccionado == null) {
                System.out.println("Ingrese su nombre de usuario:");
                String nombreUsuario = sc.nextLine();
                if (nombreUsuario.equals(usuario1.getNombre())) {
                    usuarioSeleccionado = usuario1;
                } else if (nombreUsuario.equals(usuario2.getNombre())) {
                    usuarioSeleccionado = usuario2;
                } else if (nombreUsuario.equals(admin.getNombre())) {
                    usuarioSeleccionado = admin;
                    break; // Si es administrador, salir del ciclo de login
                } else {
                    System.out.println("Usuario no encontrado. Intente nuevamente.");
                }
            }

            // Menú de administración si el usuario es administrador
            if (usuarioSeleccionado instanceof Administrador) {
                boolean salirAdminMenu = false;
                while (!salirAdminMenu) {
                    System.out.println("\nMenú de Administración:");
                    System.out.println("1. Configurar precio de asiento");
                    System.out.println("2. Agregar nueva sala");
                    System.out.println("3. Agregar nueva función");
                    System.out.println("4. Salir del menú de administración");
                    System.out.println("5. Volver al inicio");
                    System.out.print("Selecciona una opción: ");
                    int opcionAdmin = sc.nextInt();
                    sc.nextLine();  // Limpiar buffer

                    switch (opcionAdmin) {
                        case 1:
                            System.out.println("\nConfigurar precios de los asientos:");
                            System.out.println("1. Estándar");
                            System.out.println("2. VIP");
                            System.out.println("3. 4D");
                            System.out.print("Selecciona el tipo de asiento: ");
                            int tipoAsiento = sc.nextInt();
                            sc.nextLine(); // Limpiar buffer
                            System.out.print("Ingresa el nuevo precio: ");
                            double precio = sc.nextDouble();
                            sc.nextLine(); // Limpiar buffer

                            // Actualización de precios globales
                            if (tipoAsiento == 1) {
                                admin.gestionarPrecios(cine, asiento3.getTipoAsiento(), precio);
                            } else if (tipoAsiento == 2) {
                                admin.gestionarPrecios(cine, asiento2.getTipoAsiento(), precio);
                            } else if (tipoAsiento == 3) {
                                admin.gestionarPrecios(cine, asiento1.getTipoAsiento(), precio);
                            } else {
                                System.out.println("Tipo de asiento no válido.");
                            }
                            break;

                        case 2:
                            // Agregar nueva sala
                            System.out.print("\nIngrese el número de la nueva sala: ");
                            int numeroSala = sc.nextInt();
                            sc.nextLine();  // Limpiar buffer
                            System.out.print("Ingrese el tipo de sala (Ejemplo: Estándar, VIP): ");
                            String tipoSala = sc.nextLine();

                            Sala nuevaSala = new Sala(numeroSala, tipoSala);
                            admin.agregarSala(cine, nuevaSala);
                            break;

                        case 3:
                            // Agregar nueva función
                            System.out.print("\nIngrese el número de la sala para agregar la función: ");
                            int numeroSalaFuncion = sc.nextInt();
                            sc.nextLine();  // Limpiar buffer
                            Sala salaSeleccionada = cine.getSalaPorNumero(numeroSalaFuncion);

                            if (salaSeleccionada != null) {
                                System.out.print("Ingrese la hora de inicio de la función (formato: YYYY-MM-DD HH:mm): ");
                                String horaInicioStr = sc.nextLine();
                                System.out.print("Ingrese la hora de fin de la función (formato: YYYY-MM-DD HH:mm): ");
                                String horaFinStr = sc.nextLine();

                                LocalDateTime horaInicio = LocalDateTime.parse(horaInicioStr.replace(" ", "T"));
                                LocalDateTime horaFin = LocalDateTime.parse(horaFinStr.replace(" ", "T"));

                                Funcion nuevaFuncion = new Funcion(horaInicio, horaFin);
                                admin.agregarFuncion(salaSeleccionada, nuevaFuncion);
                            } else {
                                System.out.println("Sala no encontrada.");
                            }
                            break;

                        case 4:
                            // Salir del menú de administración y terminar el programa
                            System.out.println("Saliendo del menú de administración. Fin del programa.");
                            sc.close();
                            return;

                        case 5:
                            // Volver al inicio
                            System.out.println("Regresando al inicio (cambios guardados)...");
                            volverAlInicio = true;
                            salirAdminMenu = true;
                            break;

                        default:
                            System.out.println("Opción no válida. Intenta nuevamente.");
                    }
                }
            } else {
                // Si el usuario no es administrador (es cliente), mostrar las funciones disponibles y permitirle reservar un asiento
                System.out.println("¡Bienvenido " + usuarioSeleccionado.getNombre() + "!");

                // Selección de función
                Funcion funcionSeleccionada = null;
                while (funcionSeleccionada == null) {
                    System.out.println("\nFunciones disponibles:");
                    for (int i = 0; i < sala1.getFunciones().size(); i++) {
                        System.out.println((i + 1) + ". Función a las " + sala1.getFunciones().get(i).getHoraInicio());
                    }
                    System.out.println("Seleccione la función (1-" + sala1.getFunciones().size() + "):");
                    int seleccionFuncion = sc.nextInt();
                    sc.nextLine(); // Limpiar buffer
                    if (seleccionFuncion > 0 && seleccionFuncion <= sala1.getFunciones().size()) {
                        funcionSeleccionada = sala1.getFunciones().get(seleccionFuncion - 1);
                    } else {
                        System.out.println("Selección inválida. Intente nuevamente.");
                    }
                }

                // Mostrar asientos disponibles para la función seleccionada
                System.out.println("\nAsientos disponibles para la función seleccionada:");
                ArrayList<Asiento> asientosLibres = new ArrayList<>();
                for (Asiento asiento : sala1.getAsientos()) {
                    if (asiento.getEstado() == EstadoAsiento.DISPONIBLE) {
                        asientosLibres.add(asiento);
                        System.out.println("Asiento " + asiento.getNumero() + " - $" + asiento.obtenerPrecio() + " (" + asiento.getTipoAsiento().getClass().getSimpleName() + ")");
                    }
                }

                // Reserva de asiento
                Asiento asientoReservado = null;
                while (asientoReservado == null) {
                    System.out.println("Seleccione el número del asiento a reservar:");
                    int asientoSeleccionado = sc.nextInt();
                    sc.nextLine();

                    asientoReservado = asientosLibres.stream()
                            .filter(a -> a.getNumero() == asientoSeleccionado)
                            .findFirst()
                            .orElse(null);

                    if (asientoReservado == null) {
                        System.out.println("Asiento no disponible o inválido. Intente nuevamente.");
                    }
                }

                // Realizar pago
                double precioAsiento = asientoReservado.obtenerPrecio();
                System.out.println("El precio del asiento es: $" + precioAsiento);
                double montoPago = 0.0;

                while (montoPago < precioAsiento) {
                    System.out.println("Ingrese el monto a pagar:");
                    montoPago = sc.nextDouble();

                    if (montoPago < precioAsiento) {
                        System.out.println("Pago no exitoso. El monto es insuficiente. Intente nuevamente.");
                    } else if (montoPago > precioAsiento) {
                        double cambio = montoPago - precioAsiento;
                        System.out.println("Pago exitoso. Su cambio es: $" + cambio);
                    } else {
                        System.out.println("Pago exitoso. Monto exacto.");
                    }
                }

                // Confirmar reserva
                ArrayList<Asiento> asientosReservados = new ArrayList<>();
                asientosReservados.add(asientoReservado);
                Reserva reserva = new Reserva(usuarioSeleccionado, asientosReservados);
                usuarioSeleccionado.agregarReserva(reserva);

                reserva.confirmarReserva();
                System.out.println("Reserva confirmada para el asiento " + asientoReservado.getNumero() + ".");

                // Resolver reporte de un cliente
                soporte.manejarReporte(usuario1, "Problema con el asiento.");

                // Realizar una notificación de una función
                gestor.notificarCambio("La función de las 7:00 PM ha sido retrasada.");
            }

        } while (volverAlInicio);

        // Cerrar el scanner
        sc.close();
    }
}
