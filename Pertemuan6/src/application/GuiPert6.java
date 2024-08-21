package application;

import java.time.LocalDate;

import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import jfxtras.scene.control.agenda.Agenda;
import jfxtras.scene.control.agenda.Agenda.Appointment;
import jfxtras.scene.control.agenda.Agenda.AppointmentGroup;

public class GuiPert6 extends FlowPane{

	public GuiPert6() {
		Agenda agenda = new Agenda();
		agenda.setPrefSize(500, 500);
		AppointmentGroup group = new Agenda.AppointmentGroupImpl().withStyleClass("Group 1");
		Appointment todayEvent = new Agenda.AppointmentImplLocal()
				.withStartLocalDateTime(LocalDate.now().atTime(19,00))
				.withEndLocalDateTime(LocalDate.now().atTime(22,30))
				.withDescription("My event")
				.withAppointmentGroup(group);
		
		agenda.appointments().add(todayEvent);
		this.getChildren().addAll(new Label("Pertemuan 6"), agenda);
	}

}
