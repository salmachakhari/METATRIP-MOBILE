package com.metatrip.gui.back;

import com.codename1.components.ImageViewer;
import com.codename1.ui.*;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.metatrip.gui.Login;

public class AccueilBack extends Form {

    Resources theme = UIManager.initFirstTheme("/theme");
    Label label;

    public AccueilBack() {
        super("Menu", new BoxLayout(BoxLayout.Y_AXIS));
        addGUIs();
    }

    private void addGUIs() {
        ImageViewer userImage = new ImageViewer(theme.getImage("default.jpg").fill(200, 200));
        userImage.setUIID("candidatImage");
        label = new Label("Admin"/*MainApp.getSession().getEmail()*/);
        label.setUIID("links");
        Button btnDeconnexion = new Button();
        btnDeconnexion.setUIID("buttonLogout");
        btnDeconnexion.setMaterialIcon(FontImage.MATERIAL_ARROW_FORWARD);
        btnDeconnexion.addActionListener(action -> {
            Login.loginForm.showBack();
        });

        Container userContainer = new Container(new BorderLayout());
        userContainer.setUIID("userContainer");
        userContainer.add(BorderLayout.WEST, userImage);
        userContainer.add(BorderLayout.CENTER, label);
        userContainer.add(BorderLayout.EAST, btnDeconnexion);

        Container menuContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        menuContainer.addAll(
                userContainer,
                makeHotelsButton(), 
                makeChauffeursButton(), 
                makeAbonnementsButton(),
                makeVoyageButton(),
                MakeVoyageOrganiseButton() ,
                MakeStatOrganiseButton(),
                makeUserButton() 
                
        );

        this.add(menuContainer);
    }
 private Button makeVoyageButton() {
        Button button = new Button("Voyage");
        button.setUIID("buttonMenu");
        //button.setMaterialIcon(FontImage.MATERIAL_BOOKMARK);
        button.addActionListener(action -> new com.metatrip.gui.back.hotel.ShowAll(this).show());
        return button;
    }
 private Button MakeVoyageOrganiseButton() {
        Button button = new Button("Voyage Organisé");
        button.setUIID("buttonMenu");
        //button.setMaterialIcon(FontImage.MATERIAL_BOOKMARK);
        button.addActionListener(action -> new com.metatrip.gui.back.hotel.ShowAll(this).show());
        return button;
    }
  private Button MakeStatOrganiseButton() {
        Button button = new Button("Statistique");
        button.setUIID("buttonMenu");
        //button.setMaterialIcon(FontImage.MATERIAL_BOOKMARK);
        button.addActionListener(action -> new com.metatrip.gui.back.hotel.ShowAll(this).show());
        return button;
    }
 private Button makeUserButton() {
        Button button = new Button("User");
        button.setUIID("buttonMenu");
        //button.setMaterialIcon(FontImage.MATERIAL_BOOKMARK);
        button.addActionListener(action -> new com.metatrip.gui.back.hotel.ShowAll(this).show());
        return button;
    }
    private Button makeHotelsButton() {
        Button button = new Button("Hotels");
        button.setUIID("buttonMenu");
        //button.setMaterialIcon(FontImage.MATERIAL_BOOKMARK);
        button.addActionListener(action -> new com.metatrip.gui.back.hotel.ShowAll(this).show());
        return button;
    }
    private Button makeChauffeursButton() {
        Button button = new Button("Chauffeurs");
        button.setUIID("buttonMenu");
        //button.setMaterialIcon(FontImage.MATERIAL_BOOKMARK);
        button.addActionListener(action -> new com.metatrip.gui.back.chauffeur.ShowAll(this).show());
        return button;
    }
    private Button makeAbonnementsButton() {
        Button button = new Button("Abonnements");
        button.setUIID("buttonMenu");
        //button.setMaterialIcon(FontImage.MATERIAL_BOOKMARK);
        button.addActionListener(action -> new com.metatrip.gui.back.abonnement.ShowAll(this).show());
        return button;
    }
    
}
