package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class ScheduleApp {
	private final Scanner scanner;
	private final Schedule schedule;

	@Autowired
	public ScheduleApp(Scanner scanner, Schedule schedule) {
		this.scanner = scanner;
		this.schedule = schedule;
	}


    public void start() {
			while (true) {
				System.out.println("Меню:");
				System.out.println("1. Додати заняття до розкладу");
				System.out.println("2. Видалити заняття з розкладу");
				System.out.println("3. Переглянути розклад для певної групи");
				System.out.println("4. Переглянути усі заняття розкладу");
				System.out.println("5. Переглянути пропозиції по зміні розкладу");
				System.out.println("6. Згенерувати розклад");
				System.out.println("7. Вийти");

				int choice = scanner.nextInt();
				scanner.nextLine(); // consume newline

				switch (choice) {
					case 1:
						addClassToSchedule();
						break;
					case 2:
						removeClassFromSchedule();
						break;
					case 3:
						viewScheduleForGroup();
						break;
					case 4:
						viewAllClasses();
						break;
					case 5:
						viewScheduleChangeProposals();
						break;
					case 6:
						generateSchedule();
						break;
					case 7:
						return;
					default:
						System.out.println("Невірний вибір. Спробуйте ще раз.");
				}
			}
		}

		private void addClassToSchedule() {
			System.out.println("Введіть назву заняття:");
			String className = scanner.nextLine();

			System.out.println("Введіть назву групи:");
			String groupName = scanner.nextLine();

			System.out.println("Введіть день тижня:");
			String dayOfWeek = scanner.nextLine();

			System.out.println("Введіть час:");
			String time = scanner.nextLine();

			ClassSchedule classSchedule = new ClassSchedule(className, groupName, dayOfWeek, time);
			schedule.addClass(classSchedule);
			System.out.println("Заняття додано до розкладу.");
		}

		private void removeClassFromSchedule() {
			System.out.println("Введіть назву заняття для видалення:");
			String className = scanner.nextLine();
			schedule.removeClass(className);
			System.out.println("Заняття видалено з розкладу.");
		}

		private void viewScheduleForGroup() {
			System.out.println("Введіть назву групи:");
			String groupName = scanner.nextLine();
			List<ClassSchedule> scheduleForGroup = schedule.getScheduleForGroup(groupName);
			if (scheduleForGroup.isEmpty()) {
				System.out.println("Розклад для цієї групи порожній.");
			} else {
				System.out.println("Розклад для групи " + groupName + ":");
				for (ClassSchedule classSchedule : scheduleForGroup) {
					System.out.println(classSchedule.getClassName() + " " + classSchedule.getDayOfWeek() + " " + classSchedule.getTime());
				}
			}
		}

		private void viewAllClasses() {
			List<ClassSchedule> allClasses = schedule.getAllClasses();
			if (allClasses.isEmpty()) {
				System.out.println("Розклад порожній.");
			} else {
				System.out.println("Усі заняття розкладу:");
				for (ClassSchedule classSchedule : allClasses) {
					System.out.println(classSchedule.getClassName() + " " + classSchedule.getGroupName() + " " +
							classSchedule.getDayOfWeek() + " " + classSchedule.getTime());
				}
			}
		}

		private void viewScheduleChangeProposals() {
			List<String> proposals = schedule.getScheduleChangeProposals();
			if (proposals.isEmpty()) {
				System.out.println("Немає пропозицій по зміні розкладу.");
			} else {
				System.out.println("Пропозиції по зміні розкладу:");
				for (String proposal : proposals) {
					System.out.println(proposal);
				}
			}
		}

		private void generateSchedule() {
			boolean success = schedule.generateSchedule();
			if (success) {
				System.out.println("Розклад згенеровано успішно.");
			} else {
				System.out.println("Не вдалося згенерувати розклад. Перевірте наявність конфліктів.");
			}
		}
}

