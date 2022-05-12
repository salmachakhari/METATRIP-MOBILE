 
package com.mycompany.gui;

import com.codename1.components.InfiniteProgress;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.BOTTOM;
import static com.codename1.ui.Component.CENTER;
import static com.codename1.ui.Component.LEFT;
import static com.codename1.ui.Component.RIGHT;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.Tabs;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.list.MultiList;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.mycompany.entities.voyage;
import com.mycompany.services.VoyageService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author bhk
 */
public class ListVoyagesForm extends Form {
 Form current;
 static int nb;
 
    public int getNb(){return nb;}
        private Map<String, Object> createListEntry(voyage p) {
        Map<String, Object> entry = new HashMap<>();
                entry.put("Line1", p.getIdv());

        entry.put("Line2", p.getImage_pays());
        entry.put("Line3", p.getPays());
         entry.put("Line4", "                                        ");
nb++;
        return entry;
        
      
    }

    public ListVoyagesForm(Form previous) {
        current=this; //Back

        System.out.println(VoyageService.getInstance().getAllTasks().toString());
        ArrayList<voyage> data = VoyageService.getInstance().getAllTasks();
        ArrayList<Map<String, Object>> dataToAdd = new ArrayList<>();

        for (voyage p : data) {
            dataToAdd.add(createListEntry(p));
        }
        System.out.println("nombre"+nb);
        DefaultListModel<Map<String, Object>> model = new DefaultListModel<>(dataToAdd);

        MultiList ml = new MultiList(model);
         ml.addActionListener(new ActionListener() {

       
               @Override
            public void actionPerformed(ActionEvent evt) {
                String res=evt.getActualComponent().toString();
                String idv=res.substring(res.indexOf("selected index = ")+17);
                idv=idv.substring(0,idv.indexOf(','));
                System.out.println(Integer.parseInt(idv));
                new VoyageUpdateGUI(current,data.get(Integer.parseInt(idv))).show();
            }
        });
 addAll(ml);    
          getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());

    }

   
}
