Bot Assigner

El bot lee usuarios de un archivo excel usando Data Provider. Utiliza page objet model para mantener el codigo principal y las paginas

bien estructuradas y legible. Haciendolo más sencillo de mantener y escribir los tests. 

Inicia Chrome en la URL de tickets, Si el usuario esta en shift, inicia el bucle que se va a repetir hasta que encuentre un ticket sin asignar.

Si el usuario no esta en shift, pasa al siguiente y hace la verificacion de nuevo.

Imprime el NTID y QUEUE del usuario en shift al que se le va a asignar un ticket.

Selecciona la pestaña de MyQueues (desde un ENUM con la lista de solapas del header),

en donde esta la lista de todos los tickets y un dropdown para seleccionar la queue.

Espera 20 segundos (esa pagina tardaba mucho en cargar, a veces no respondia), si no cargaba, cambia de puestaña y vuelve, para hacer un refresh.

Selecciona un checkbox para mostrar solo los tickets sin asignar, seleccionaba el dropdown de queues y verificaba que este la queue

a la que corresponde el usuario.

Si no encuentra ticket, imprime un mensaje vuelve a buclear (lo hara hasta que encuentre un ticket)

Si encuentra un ticket, sale del bucle y continua con la asignacion.

Imprime un mensaje, selecciona el ticket (el primer en status Unassigned), imprime el numero en consola y lo guarda en un string

(para ser uasdo luego en el mail)

Selecciona el boton Assign / Update, y realiza los pasos para asignar al usuario actual.

Obtiene la url del ticket (para ser usada en el mail)

repite los pasos para asignar, pero en vez de hacer asignacion, pone el ticket en status Work in progress.

Llama a la funcion sendMail que usa un batch con codigo para enviar mail, enviando el numero de ticket al usuario actual.

Da un mensaje en consola de que se asignó un ticket y espera 2 minutos para actualizar la pagina antes de repetir el proceso con

el siguiente usuario (la pagina tarda aproximadamente 2 minutos en actualizar el estado del ticket) y evitar reasignar el mismo ticket.

Incrementa el contador de tickets, imprime mensajes de estado, la hora, y pasa al siguiente usuario para repetir el proceso.

