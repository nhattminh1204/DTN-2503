package Composite_2;

public class Program {
    public static void main(String[] args) {
        SubMenu fileMenu = new SubMenu("File");
        SubMenu newMenu = new SubMenu("New");
        MenuItem openMenuItem = new MenuItem("Open");
        MenuItem saveMenuItem = new MenuItem("Save");
        MenuItem projectMenuItem = new MenuItem("Project");
        MenuItem fileMenuItem = new MenuItem("File");

        newMenu.add(projectMenuItem);
        newMenu.add(fileMenuItem);

        fileMenu.add(newMenu);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);

        SubMenu editMenu = new SubMenu("Edit");
        MenuItem cutMenuItem = new MenuItem("Cut");
        MenuItem copyMenuItem = new MenuItem("Copy");
        MenuItem pasteMenuItem = new MenuItem("Paste");

        editMenu.add(cutMenuItem);
        editMenu.add(copyMenuItem);
        editMenu.add(pasteMenuItem);

        SubMenu mainMenu = new SubMenu("Main Menu");
        mainMenu.add(fileMenu);
        mainMenu.add(editMenu);

        // Hiển thị menu bắt đầu từ cấp 0
        mainMenu.showMenu(0);
    }
}
