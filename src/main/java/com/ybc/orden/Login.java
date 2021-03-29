package com.ybc.orden;



import com.ybc.orden.views.MainFrame;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Login extends javax.swing.JFrame {

    public static ApplicationContext context; 
    
    public Login() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
    }

    public static void displayAllBeans() {
        String[] allBeanNames = context.getBeanDefinitionNames();
        for (String beanName : allBeanNames) {
            System.out.println(beanName);
        }
    }

    public static void main(String... args) throws Exception {
        context = new SpringApplicationBuilder(Login.class).headless(false).run(args);
        //displayAllBeans();        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                System.out.println("");
                Login login = context.getBean(Login.class);
                login.setVisible(true);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        rSLabelIcon1 = new RSMaterialComponent.RSLabelIcon();
        rSButtonMaterialIconOne1 = new RSMaterialComponent.RSButtonMaterialIconOne();
        jPanel2 = new javax.swing.JPanel();
        rSLabelIcon2 = new RSMaterialComponent.RSLabelIcon();
        rSLabelIcon3 = new RSMaterialComponent.RSLabelIcon();
        rSTextFieldMaterial1 = new RSMaterialComponent.RSTextFieldMaterial();
        rSPasswordMaterial1 = new RSMaterialComponent.RSPasswordMaterial();
        rSButtonMaterialIconOne2 = new RSMaterialComponent.RSButtonMaterialIconOne();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255), 2));

        rSLabelIcon1.setForeground(new java.awt.Color(51, 153, 255));
        rSLabelIcon1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.TOUCH_APP);
        rSLabelIcon1.setSizeIcon(200.0F);

        rSButtonMaterialIconOne1.setBackground(new java.awt.Color(0, 153, 51));
        rSButtonMaterialIconOne1.setText("Ingresar");
        rSButtonMaterialIconOne1.setBackgroundHover(new java.awt.Color(0, 102, 0));
        rSButtonMaterialIconOne1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rSButtonMaterialIconOne1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.APPS);
        rSButtonMaterialIconOne1.setRound(30);
        rSButtonMaterialIconOne1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMaterialIconOne1ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        rSLabelIcon2.setForeground(new java.awt.Color(51, 153, 255));
        rSLabelIcon2.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ACCOUNT_CIRCLE);

        rSLabelIcon3.setForeground(new java.awt.Color(51, 153, 255));
        rSLabelIcon3.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.KEYBOARD);

        rSTextFieldMaterial1.setBackground(new java.awt.Color(255, 255, 255));
        rSTextFieldMaterial1.setForeground(new java.awt.Color(0, 0, 0));
        rSTextFieldMaterial1.setColorMaterial(new java.awt.Color(51, 153, 255));
        rSTextFieldMaterial1.setPhColor(new java.awt.Color(0, 0, 0));
        rSTextFieldMaterial1.setPlaceholder("Usuario");
        rSTextFieldMaterial1.setSelectionColor(new java.awt.Color(51, 153, 255));

        rSPasswordMaterial1.setBackground(new java.awt.Color(255, 255, 255));
        rSPasswordMaterial1.setForeground(new java.awt.Color(0, 0, 0));
        rSPasswordMaterial1.setColorMaterial(new java.awt.Color(51, 153, 255));
        rSPasswordMaterial1.setPhColor(new java.awt.Color(0, 0, 0));
        rSPasswordMaterial1.setPlaceholder("Contraseña");
        rSPasswordMaterial1.setSelectionColor(new java.awt.Color(51, 153, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(rSLabelIcon2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rSTextFieldMaterial1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(rSLabelIcon3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rSPasswordMaterial1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(12, 12, 12))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rSLabelIcon2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSTextFieldMaterial1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rSLabelIcon3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSPasswordMaterial1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        rSButtonMaterialIconOne2.setBackground(new java.awt.Color(255, 51, 51));
        rSButtonMaterialIconOne2.setText("Salir");
        rSButtonMaterialIconOne2.setBackgroundHover(new java.awt.Color(153, 0, 0));
        rSButtonMaterialIconOne2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rSButtonMaterialIconOne2.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXIT_TO_APP);
        rSButtonMaterialIconOne2.setRound(30);
        rSButtonMaterialIconOne2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMaterialIconOne2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rSLabelIcon1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rSButtonMaterialIconOne1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rSButtonMaterialIconOne2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rSLabelIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rSButtonMaterialIconOne1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rSButtonMaterialIconOne2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rSButtonMaterialIconOne1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMaterialIconOne1ActionPerformed

       dispose();
       MainFrame mainFrame = context.getBean(MainFrame.class);
       mainFrame.setVisible(true);

    }//GEN-LAST:event_rSButtonMaterialIconOne1ActionPerformed

    private void rSButtonMaterialIconOne2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMaterialIconOne2ActionPerformed

        System.exit(0);
        
    }//GEN-LAST:event_rSButtonMaterialIconOne2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private RSMaterialComponent.RSButtonMaterialIconOne rSButtonMaterialIconOne1;
    private RSMaterialComponent.RSButtonMaterialIconOne rSButtonMaterialIconOne2;
    private RSMaterialComponent.RSLabelIcon rSLabelIcon1;
    private RSMaterialComponent.RSLabelIcon rSLabelIcon2;
    private RSMaterialComponent.RSLabelIcon rSLabelIcon3;
    private RSMaterialComponent.RSPasswordMaterial rSPasswordMaterial1;
    private RSMaterialComponent.RSTextFieldMaterial rSTextFieldMaterial1;
    // End of variables declaration//GEN-END:variables

}
