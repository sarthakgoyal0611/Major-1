package imagestegano;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.io.File;
import java.nio.file.Files;
import javax.imageio.ImageIO;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import steganography.LSBEncoding;
import utility.ImageUtility;

public class HideText extends javax.swing.JFrame {

    JFileChooser fileChooser;
    File textFile;
    BufferedImage coverImage;
    ImageUtility imageUtility;
    ColorModel coverImageColorModel;
    File openedFile;
    
    // an array to hold all bits checkboxes
    JCheckBox bitsCheckBoxArray[] = new JCheckBox[8];
    
    /**
     * Creates new form HideText
     */
    public HideText() {
        initComponents();
        fileChooser = new JFileChooser();
        imageUtility = new ImageUtility();
        
        bitsCheckBoxArray[0] = bit0CheckBox;
        bitsCheckBoxArray[1] = bit1CheckBox;
        bitsCheckBoxArray[2] = bit2CheckBox;
        bitsCheckBoxArray[3] = bit3CheckBox;
        bitsCheckBoxArray[4] = bit4CheckBox;
        bitsCheckBoxArray[5] = bit5CheckBox;
        bitsCheckBoxArray[6] = bit6CheckBox;
        bitsCheckBoxArray[7] = bit7CheckBox;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        chooseTextFileButton = new javax.swing.JButton();
        textFileLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        secretMessageTextFiled = new javax.swing.JTextField();
        bitPlanesPanel = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        bit5CheckBox = new javax.swing.JCheckBox();
        bit4CheckBox = new javax.swing.JCheckBox();
        bit3CheckBox = new javax.swing.JCheckBox();
        bit2CheckBox = new javax.swing.JCheckBox();
        bit1CheckBox = new javax.swing.JCheckBox();
        bit0CheckBox = new javax.swing.JCheckBox();
        bit7CheckBox = new javax.swing.JCheckBox();
        bit6CheckBox = new javax.swing.JCheckBox();
        hideTextButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        chooseCoverImageButton = new javax.swing.JButton();
        coverImageLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Hide Text");

        jLabel2.setText("Choose a text File");

        chooseTextFileButton.setText("Choose text file");
        chooseTextFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseTextFileButtonActionPerformed(evt);
            }
        });

        textFileLabel.setForeground(new java.awt.Color(140, 56, 104));

        jLabel4.setText("OR");

        jLabel5.setText("Enter text to hide: ");

        bitPlanesPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Modify Bits"));
        bitPlanesPanel.setToolTipText("Modify Bits");
        bitPlanesPanel.setName(""); // NOI18N

        jLabel10.setText("Select Bits:");

        bit5CheckBox.setText("5");

        bit4CheckBox.setText("4");

        bit3CheckBox.setText("3");

        bit2CheckBox.setText("2");

        bit1CheckBox.setText("1");

        bit0CheckBox.setText("0");

        bit7CheckBox.setText("7");

        bit6CheckBox.setText("6");

        javax.swing.GroupLayout bitPlanesPanelLayout = new javax.swing.GroupLayout(bitPlanesPanel);
        bitPlanesPanel.setLayout(bitPlanesPanelLayout);
        bitPlanesPanelLayout.setHorizontalGroup(
            bitPlanesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bitPlanesPanelLayout.createSequentialGroup()
                .addComponent(jLabel10)
                .addGap(52, 52, 52)
                .addComponent(bit7CheckBox)
                .addGap(30, 30, 30)
                .addComponent(bit6CheckBox)
                .addGap(18, 18, 18)
                .addComponent(bit5CheckBox)
                .addGap(18, 18, 18)
                .addComponent(bit4CheckBox)
                .addGap(18, 18, 18)
                .addComponent(bit3CheckBox)
                .addGap(18, 18, 18)
                .addComponent(bit2CheckBox)
                .addGap(18, 18, 18)
                .addComponent(bit1CheckBox)
                .addGap(27, 27, 27)
                .addComponent(bit0CheckBox)
                .addContainerGap(167, Short.MAX_VALUE))
        );
        bitPlanesPanelLayout.setVerticalGroup(
            bitPlanesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bitPlanesPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(bitPlanesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(bit7CheckBox)
                    .addComponent(bit6CheckBox)
                    .addComponent(bit5CheckBox)
                    .addComponent(bit4CheckBox)
                    .addComponent(bit3CheckBox)
                    .addComponent(bit2CheckBox)
                    .addComponent(bit1CheckBox)
                    .addComponent(bit0CheckBox)))
        );

        hideTextButton.setText("Hide Text");
        hideTextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hideTextButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Choose Cover Image:");

        chooseCoverImageButton.setText("Choose Cover Image");
        chooseCoverImageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseCoverImageButtonActionPerformed(evt);
            }
        });

        coverImageLabel.setForeground(new java.awt.Color(140, 56, 104));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(261, 261, 261)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)
                                .addGap(73, 73, 73)
                                .addComponent(chooseTextFileButton)
                                .addGap(18, 18, 18)
                                .addComponent(textFileLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)))
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel1))
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(secretMessageTextFiled)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(chooseCoverImageButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(coverImageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addComponent(bitPlanesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(248, 248, 248)
                .addComponent(hideTextButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(chooseTextFileButton))
                        .addGap(42, 42, 42)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(textFileLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(secretMessageTextFiled, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(coverImageLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(chooseCoverImageButton)
                        .addComponent(jLabel1)))
                .addGap(18, 18, 18)
                .addComponent(bitPlanesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(hideTextButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chooseTextFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseTextFileButtonActionPerformed
        fileChooser.setDialogTitle("Choose a plain Text File");
        TextFileFilter filter = new TextFileFilter();
        fileChooser.setFileFilter(filter);
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            textFile = fileChooser.getSelectedFile();
            String name = textFile.getName();
            textFileLabel.setText(name);
        } 
    }//GEN-LAST:event_chooseTextFileButtonActionPerformed

    private void chooseCoverImageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseCoverImageButtonActionPerformed
        fileChooser.setDialogTitle("Select an image");
        ImageFileFilter imageFilter = new ImageFileFilter();
        fileChooser.setFileFilter(imageFilter);
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            openedFile = fileChooser.getSelectedFile();
            String name = openedFile.getName();
            try {
                if (imageFilter.isPNGOrBMPImage(name)) {
                    coverImage = ImageIO.read(openedFile);

                    // converting original image to suitable type
                    BufferedImage currentImage
                            = imageUtility.convertImage(coverImage);
                    if (currentImage != null) {
                        coverImage = currentImage;
                    }
                    
                    coverImageColorModel = coverImage.getColorModel();
                    coverImageLabel.setText(name + ", size: "
                            + openedFile.length() / 1024 + " KB, "
                            + coverImage.getWidth() + "X"
                            + coverImage.getHeight());
                } else {
                    alert("Please select only .png or .bmp image");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_chooseCoverImageButtonActionPerformed

    private void hideTextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hideTextButtonActionPerformed
        if (coverImage == null) {
            alert("No cover Image selected");
            return;
        }
        String secretMessage = "";
        if (textFile == null) {
            secretMessage = secretMessageTextFiled.getText();
            if (secretMessage.equals("")) {
                alert("Enter secret message to hide");
                return;
            }
        } else {
            try {
                byte[] encoded = Files.readAllBytes(textFile.toPath());
                secretMessage = new String(encoded);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        LSBEncoding lsbEncoding = new LSBEncoding();
        int bitArray[] = new int[8];
        for (int i = 0; i < 8; i++) {
            if (bitsCheckBoxArray[i].isSelected()) {
                bitArray[i] = 1;
            } else {
                bitArray[i] = 0;
            }
        }
        lsbEncoding.encodeText(coverImage, secretMessage, bitArray);
        saveImage();
        
    }

    public static void main(String args[]) {
  
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HideText.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HideText.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HideText.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HideText.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HideText().setVisible(true);
            }
        });
    }
    
    private void alert(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
    
    private void saveImage() {
        if (coverImage == null) {
            return;
        }
        fileChooser.setDialogTitle("Choose a location");
        String oldFileName = openedFile.getName();
        String newFileName = imageUtility.getNewFileName(oldFileName);
        String path = openedFile.getAbsolutePath();
        path = path.substring(0, path.lastIndexOf(File.separator) + 1);
        File file = new File(path + newFileName);
        fileChooser.setSelectedFile(file);
        int returnVal = fileChooser.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
            String name = file.getName();
            if (imageUtility.isImage(name)) {
                imageUtility.saveImage(coverImage, file);
            } else {
                alert("Invalid file name");
            }

        } 
    }
    private javax.swing.JCheckBox bit0CheckBox;
    private javax.swing.JCheckBox bit1CheckBox;
    private javax.swing.JCheckBox bit2CheckBox;
    private javax.swing.JCheckBox bit3CheckBox;
    private javax.swing.JCheckBox bit4CheckBox;
    private javax.swing.JCheckBox bit5CheckBox;
    private javax.swing.JCheckBox bit6CheckBox;
    private javax.swing.JCheckBox bit7CheckBox;
    private javax.swing.JPanel bitPlanesPanel;
    private javax.swing.JButton chooseCoverImageButton;
    private javax.swing.JButton chooseTextFileButton;
    private javax.swing.JLabel coverImageLabel;
    private javax.swing.JButton hideTextButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField secretMessageTextFiled;
    private javax.swing.JLabel textFileLabel;
    // End of variables declaration//GEN-END:variables
}
