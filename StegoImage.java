package imagestegano;
import data.CustomIndexColorModel;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.IndexColorModel;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import steganography.BitPlane;
import steganography.BitwiseXOR;
import steganography.ColourMap;
import steganography.ImageManipulation;
import utility.ImageUtility;

import com.drew.imaging.ImageMetadataReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import java.awt.Dimension;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
//import steganography.AppendedData;
import steganography.PNGCheck;
public class StegoImage extends javax.swing.JFrame {

    BufferedImage originalImage;
    BufferedImage currentImage;
    ImageUtility imageUtility;
    BitPlane bitPlane;
    File openedFile;
    BitwiseXOR bitwiseXOR;
    ColourMap colourMap;
    
    // pixel size of original image
    int pixelSize;
    
    /**
     * value of bpcsIndex - 
     * [-8, -1] all plane where -8 is MSB and -1 is LSB
     * [0, 7] blue plane where 0 is MSB and 7 is LSB 
     * [8, 15] green plane where 8 is MSB and 15 is LSB 
     * [16, 23] red plane
     * if alpha channel is present then [0, 7] alpha plane, 0 is MSB and
     * all other planes is shifted by one byte
     * color model is ABGR or BGR (in byte array)
     */
    int bpcsIndex;
    // negative index will be used for all plane BitPlane 
    int minBPCSIndex;
    
    // value of colourMapIndex - [0, 7] for 8 different colour maps
    int colourMapIndex;
    
    // value of bitwiseXORIndex [1, 28] (4 * 4 + 4 * 3)
    // see mapping method in BitwiseXOR.java
    int bitwiseXORIndex;
    
    CustomIndexColorModel customIndexColorModelObject;
    IndexColorModel customIndexColorModels[];
    int othersIndex;
    ImageManipulation imageManipulation;
    BufferedImage coverImage;
    BufferedImage targetImage;
    File coverImageFile;

    public StegoImage() {
        originalImage = null;
        currentImage = null;
        imageUtility = new ImageUtility();
        bitPlane = new BitPlane();
        bpcsIndex = -9;
        colourMapIndex = -1;
        bitwiseXORIndex = 0;
        bitwiseXOR = new BitwiseXOR();
        colourMap = new ColourMap();
        
        //[-1, -8] all plane BitPlane
        minBPCSIndex = -8;
        
        customIndexColorModelObject = new CustomIndexColorModel();
        customIndexColorModels = 
                customIndexColorModelObject.getIndexColorModelArray();
        othersIndex = 0;
        imageManipulation = new ImageManipulation();
        coverImage = null;
        targetImage = null;
        
        initComponents();
        
        // customizing threshold menu (no menu item)
        thresholdMenu.addMenuListener(new MenuListener() {

            @Override
            public void menuSelected(MenuEvent e) {
                showThresholdFrame();
            }

            @Override
            public void menuDeselected(MenuEvent e) {
            }

            @Override
            public void menuCanceled(MenuEvent e) {
            }
        });
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        buttonGroup1 = new javax.swing.ButtonGroup();
        hideImageFrame = new javax.swing.JFrame();
        jLabel1 = new javax.swing.JLabel();
        chooseSourceImageButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        chooseTargetImageButton = new javax.swing.JButton();
        coverImageLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        hideImageButton = new javax.swing.JButton();
        targetImageLabel = new javax.swing.JLabel();
        imageHideMethodComboBox = new javax.swing.JComboBox();
        imageEncryptionComboBox = new javax.swing.JComboBox();
        encryptionLabel = new javax.swing.JLabel();
        encryptionTextField = new javax.swing.JTextField();
        resetSelectionButton = new javax.swing.JButton();
        thresholdFrame = new javax.swing.JFrame();
        currentValueLabel = new javax.swing.JLabel();
        thresholdSlider = new javax.swing.JSlider();
        currentThresholdLabel = new javax.swing.JLabel();
        previousButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        imageLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        bitPlaneRadioButton = new javax.swing.JRadioButton();
        colourMapRadioButton = new javax.swing.JRadioButton();
        bitwiseXORRadioButton = new javax.swing.JRadioButton();
        othersRadioButton = new javax.swing.JRadioButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        analyzeMenu = new javax.swing.JMenu();
        metaDataMenuItem = new javax.swing.JMenuItem();
        appendedDataMenuItem = new javax.swing.JMenuItem();
        pngCheckMenuItem = new javax.swing.JMenuItem();
        extractTextMenuItem = new javax.swing.JMenuItem();
        thresholdMenu = new javax.swing.JMenu();
        hideDataMenu = new javax.swing.JMenu();
        hideImageMenuItem = new javax.swing.JMenuItem();
        hideTextMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();

        fileChooser.setDialogTitle("Choose an image");
        fileChooser.setFileFilter(new imagestegano.ImageFileFilter());

        hideImageFrame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        hideImageFrame.setTitle("Hide Image");

        jLabel1.setText("Select a carrier Image");

        chooseSourceImageButton.setText("choose");
        chooseSourceImageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseSourceImageButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Select target image (image to hide)");

        chooseTargetImageButton.setText("choose");
        chooseTargetImageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseTargetImageButtonActionPerformed(evt);
            }
        });

        coverImageLabel.setForeground(new java.awt.Color(140, 56, 104));

        jLabel4.setText("Select method");

        jLabel3.setText("Select Encryption option");

        hideImageButton.setText("Hide Image");
        hideImageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hideImageButtonActionPerformed(evt);
            }
        });

        targetImageLabel.setForeground(new java.awt.Color(140, 56, 104));

        imageHideMethodComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0th bit plane", "1st bit plane", "2nd bit plane", "3rd bit plane" }));

        imageEncryptionComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No Encryption", "Invert Bits", "Bitwise XOR with upper bits" }));
        imageEncryptionComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageEncryptionComboBoxActionPerformed(evt);
            }
        });

        encryptionLabel.setText("No Encryption");

        encryptionTextField.setEditable(false);

        resetSelectionButton.setText("Reset selection");
        resetSelectionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetSelectionButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout hideImageFrameLayout = new javax.swing.GroupLayout(hideImageFrame.getContentPane());
        hideImageFrame.getContentPane().setLayout(hideImageFrameLayout);
        hideImageFrameLayout.setHorizontalGroup(
            hideImageFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hideImageFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(hideImageFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(hideImageFrameLayout.createSequentialGroup()
                        .addGroup(hideImageFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(hideImageFrameLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(chooseSourceImageButton))
                            .addGroup(hideImageFrameLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(chooseTargetImageButton)))
                        .addGap(48, 48, 48))
                    .addGroup(hideImageFrameLayout.createSequentialGroup()
                        .addComponent(coverImageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, hideImageFrameLayout.createSequentialGroup()
                        .addComponent(targetImageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(hideImageFrameLayout.createSequentialGroup()
                        .addGroup(hideImageFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(hideImageButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(hideImageFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, hideImageFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(imageEncryptionComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(imageHideMethodComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(encryptionTextField))
                            .addComponent(resetSelectionButton, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(50, 50, 50))
                    .addGroup(hideImageFrameLayout.createSequentialGroup()
                        .addComponent(encryptionLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        hideImageFrameLayout.setVerticalGroup(
            hideImageFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hideImageFrameLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(hideImageFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(chooseSourceImageButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(coverImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(hideImageFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(chooseTargetImageButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(targetImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(hideImageFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(imageHideMethodComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(hideImageFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(imageEncryptionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(hideImageFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(encryptionLabel)
                    .addComponent(encryptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(hideImageFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hideImageButton)
                    .addComponent(resetSelectionButton))
                .addContainerGap())
        );

        thresholdFrame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        thresholdFrame.setTitle("Threshold (Histogram)");

        currentValueLabel.setText("Current Value:");

        thresholdSlider.setMaximum(255);
        thresholdSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                thresholdSliderStateChanged(evt);
            }
        });

        currentThresholdLabel.setText("50");

        javax.swing.GroupLayout thresholdFrameLayout = new javax.swing.GroupLayout(thresholdFrame.getContentPane());
        thresholdFrame.getContentPane().setLayout(thresholdFrameLayout);
        thresholdFrameLayout.setHorizontalGroup(
            thresholdFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(thresholdFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(currentValueLabel)
                .addGap(39, 39, 39)
                .addComponent(currentThresholdLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(thresholdSlider, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        thresholdFrameLayout.setVerticalGroup(
            thresholdFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(thresholdFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(thresholdFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(currentValueLabel)
                    .addComponent(currentThresholdLabel))
                .addGap(31, 31, 31)
                .addComponent(thresholdSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Steganography Tool");
        setName("StegoImage");

        previousButton.setText("Previous");
        previousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousButtonActionPerformed(evt);
            }
        });
        previousButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                previousButtonKeyReleased(evt);
            }
        });

        nextButton.setText("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });
        nextButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nextButtonKeyReleased(evt);
            }
        });

        imageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jScrollPane1.setViewportView(imageLabel);

        nameLabel.setText("Open an Image using Ctrl + O or File menu");

        buttonGroup1.add(bitPlaneRadioButton);
        bitPlaneRadioButton.setSelected(true);
        bitPlaneRadioButton.setText("Bit Plane");

        buttonGroup1.add(colourMapRadioButton);
        colourMapRadioButton.setText("Colour Map");

        buttonGroup1.add(bitwiseXORRadioButton);
        bitwiseXORRadioButton.setText("Bitwise XOR");

        buttonGroup1.add(othersRadioButton);
        othersRadioButton.setText("Others");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bitPlaneRadioButton)
                        .addGap(54, 54, 54)
                        .addComponent(colourMapRadioButton)
                        .addGap(54, 54, 54)
                        .addComponent(bitwiseXORRadioButton)
                        .addGap(51, 51, 51)
                        .addComponent(othersRadioButton)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bitPlaneRadioButton)
                    .addComponent(colourMapRadioButton)
                    .addComponent(bitwiseXORRadioButton)
                    .addComponent(othersRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        fileMenu.setText("Menu");

        openMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        openMenuItem.setText("Open");
        openMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(openMenuItem);

        saveAsMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveAsMenuItem.setText("Save As");
        saveAsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveAsMenuItem);

        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        jMenuBar1.add(fileMenu);

        analyzeMenu.setText("Extract Data");


        extractTextMenuItem.setText("Extract Text");
        extractTextMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                extractTextMenuItemActionPerformed(evt);
            }
        });
        analyzeMenu.add(extractTextMenuItem);

        jMenuBar1.add(analyzeMenu);

       // thresholdMenu.setText("Threshold");
        jMenuBar1.add(thresholdMenu);

        hideDataMenu.setText("Steganography Technique");

        hideImageMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        hideImageMenuItem.setText("Hide Image");
        hideImageMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hideImageMenuItemActionPerformed(evt);
            }
        });
        hideDataMenu.add(hideImageMenuItem);

        hideTextMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        hideTextMenuItem.setText("Hide Text");
        hideTextMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hideTextMenuItemActionPerformed(evt);
            }
        });
        hideDataMenu.add(hideTextMenuItem);

        jMenuBar1.add(hideDataMenu);

//       helpMenu.setText("Help");
      jMenuBar1.add(helpMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(previousButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nextButton)
                .addGap(143, 143, 143))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(previousButton)
                    .addComponent(nextButton)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItemActionPerformed
        fileChooser.setDialogTitle("Select an image");
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            openedFile = fileChooser.getSelectedFile();
            String name = openedFile.getName();
            try {
                ImageFileFilter imageFilter = new ImageFileFilter();
                if (imageFilter.isImage(name)) {
                    originalImage = ImageIO.read(openedFile);
                    
                    // will initialize pixelSize variable
                    System.out.println("Original Image Info:");
                    printImageInfo(originalImage);
                    
                    // converting original image to suitable type
                    currentImage = imageUtility.convertImage(originalImage);
                    if (currentImage != null) {
                        originalImage = currentImage;
                        System.out.println("Converted Image Info:");
                        
                        // will ovverride pixelSize variable
                        printImageInfo(originalImage);
                    }
                    
                    imageLabel.setIcon(new ImageIcon(originalImage));
                    nameLabel.setText("Normal Image. Use --> " + 
                            "and <-- key to navigate.");
                } else {
                    alert("Please select an image");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File access cancelled by user.");
        }
    }//GEN-LAST:event_openMenuItemActionPerformed

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void previousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousButtonActionPerformed
        if (bitPlaneRadioButton.isSelected()) {
            if (bpcsIndex <= minBPCSIndex) {
                bpcsIndex = pixelSize;
            }
            bpcsIndex--;
            manipulateImage();
        } else if (bitwiseXORRadioButton.isSelected()) {
            if (bitwiseXORIndex <= 1) {
                bitwiseXORIndex = 29;
            }
            bitwiseXORIndex--;
            applyBitwiseXOR();
        } else if (colourMapRadioButton.isSelected()) {
            if (colourMapIndex <= 0) {
                colourMapIndex = 8;
            }
            colourMapIndex--;
            applyColourMap();
        } else if (othersRadioButton.isSelected()) {
            if (othersIndex <= 1) {
                othersIndex = 3;
            }
            othersIndex--;
            otherManipulations();
        }
    }//GEN-LAST:event_previousButtonActionPerformed

    private void previousButtonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_previousButtonKeyReleased
        int keyCode = evt.getKeyCode();
        if (keyCode == 39) {
            nextButton.doClick();
        } else if (keyCode == 37) {
            previousButton.doClick();
        }
    }//GEN-LAST:event_previousButtonKeyReleased

    private void nextButtonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nextButtonKeyReleased
        int keyCode = evt.getKeyCode();
        if (keyCode == 39) {
            nextButton.doClick();
        } else if (keyCode == 37) {
            previousButton.doClick();
        }
    }//GEN-LAST:event_nextButtonKeyReleased

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        if (bitPlaneRadioButton.isSelected()) {
            if (bpcsIndex >= pixelSize - 1) {
                bpcsIndex = minBPCSIndex - 1;
            }
            bpcsIndex++;
            manipulateImage();
        } else if (bitwiseXORRadioButton.isSelected()) {
            if (bitwiseXORIndex >= 28) {
                bitwiseXORIndex = 0;
            }
            bitwiseXORIndex++;
            applyBitwiseXOR();
        } else if (colourMapRadioButton.isSelected()) {
            if (colourMapIndex >= 7) {
                colourMapIndex = -1;
            }
            colourMapIndex++;
            applyColourMap();
        } else if (othersRadioButton.isSelected()) {
            if (othersIndex >= 2) {
                othersIndex = 0;
            }
            othersIndex++;
            otherManipulations();
        }
    }//GEN-LAST:event_nextButtonActionPerformed

    private void saveAsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsMenuItemActionPerformed
        if (currentImage == null) {
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
                imageUtility.saveImage(currentImage, file);
            } else {
                alert("Invalid file name");
            }
            
        } else {
            System.out.println("File access cancelled by user.");
        }
    }//GEN-LAST:event_saveAsMenuItemActionPerformed

    private void hideImageMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hideImageMenuItemActionPerformed
        hideImageFrame.setBounds(0, 0, 450, 320);
        hideImageFrame.setVisible(true);
    }//GEN-LAST:event_hideImageMenuItemActionPerformed

    private void hideImageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hideImageButtonActionPerformed
        if (coverImage == null) {
            alert("Please select cover image");
            return;
        }
        if (targetImage == null) {
            alert("Please select an image to hide");
            return;
        }
        int lsb = imageHideMethodComboBox.getSelectedIndex();
        int encryption = imageEncryptionComboBox.getSelectedIndex();        

        // No encryption
        if (encryption == 0) {
            bitPlane.hideImage(coverImage, targetImage, lsb, false);
        } else if (encryption == 1) {
            // invert bits
            bitPlane.hideImage(coverImage, targetImage, lsb, true);
        } else if (encryption == 2) {
            // Bitwise XOR with upper bits
            try {
                int upperBit = Integer.parseInt(encryptionTextField.getText());
                if (upperBit >= 4 && upperBit <= 7) {
                    bitPlane.hideImage(coverImage, targetImage, lsb, upperBit);
                } else {
                    alert("Enter upper bit between 4 to 7 both inclusive");
                    return;
                }
            } catch(Exception e) {
                alert("Enter upper bit between 4 to 7 both inclusive");
                return;
            }
        }
        saveSteganoImage(coverImage, coverImageFile);
    }//GEN-LAST:event_hideImageButtonActionPerformed

    private void chooseSourceImageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseSourceImageButtonActionPerformed
        fileChooser.setDialogTitle("Select a cover image");
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            openedFile = coverImageFile = fileChooser.getSelectedFile();
            String name = openedFile.getName();
            try {
                ImageFileFilter imageFilter = new ImageFileFilter();
                if (imageFilter.isPNGOrBMPImage(name)) {
                    coverImage = ImageIO.read(openedFile);
                    
                    // converting cover image to suitable type
                    BufferedImage temp = imageUtility.convertImage(coverImage);
                    
                    if (temp != null) {
                        coverImage = temp;
                    }
                    coverImageLabel.setText(name + ", size: " + 
                            openedFile.length() / 1024 + " KB, " +
                            coverImage.getWidth() + "X" +
                            coverImage.getHeight());
                } else {
                    alert("Please select only .png or .bmp image");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        printResizeImageInfo();
        
    }//GEN-LAST:event_chooseSourceImageButtonActionPerformed

    private void chooseTargetImageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseTargetImageButtonActionPerformed
        fileChooser.setDialogTitle("Select the target image");
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            openedFile = fileChooser.getSelectedFile();
            String name = openedFile.getName();
            try {
                ImageFileFilter imageFilter = new ImageFileFilter();
                if (imageFilter.isImage(name)) {
                    targetImage = ImageIO.read(openedFile);
                    
                    // converting cover image to suitable type
                    BufferedImage temp = imageUtility.convertImage(targetImage);
                    
                    if (temp != null) {
                        targetImage = temp;
                    }
                    targetImageLabel.setText(name + ", size: " + 
                            openedFile.length() / 1024 + " KB, " +
                            targetImage.getWidth() + "X" +
                            targetImage.getHeight());
                } else {
                    alert("Please select an image");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        printResizeImageInfo();
    }//GEN-LAST:event_chooseTargetImageButtonActionPerformed

    private void imageEncryptionComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageEncryptionComboBoxActionPerformed
        String selectedItem = 
                imageEncryptionComboBox.getSelectedItem().toString();
        if (selectedItem.equals("Bitwise XOR with upper bits")) {
            encryptionLabel.setText("Which upper bit (between 4-7)?");
            encryptionTextField.setEditable(true);
        } else if (selectedItem.equals("Invert Bits")) {
            encryptionLabel.setText("Bits will be inverted");
            encryptionTextField.setEditable(false);
        } else if (selectedItem.equals("No Encryption")) {
            encryptionLabel.setText("No Encryption");
            encryptionTextField.setEditable(false);
        }
    }//GEN-LAST:event_imageEncryptionComboBoxActionPerformed

    private void resetSelectionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetSelectionButtonActionPerformed
        coverImage = null;
        targetImage = null;
        coverImageLabel.setText(null);
        targetImageLabel.setText(null);
    }//GEN-LAST:event_resetSelectionButtonActionPerformed

    private void thresholdSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_thresholdSliderStateChanged
        int value = (int) thresholdSlider.getValue();
        currentThresholdLabel.setText((String.valueOf(value)));
        currentImage = imageUtility.copyImage(originalImage);
        currentImage = imageUtility.thresholdImage(currentImage, value);
        imageLabel.setIcon(new ImageIcon(currentImage));
    }//GEN-LAST:event_thresholdSliderStateChanged



    private void hideTextMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hideTextMenuItemActionPerformed
        new HideText().setVisible(true);
    }//GEN-LAST:event_hideTextMenuItemActionPerformed

    private void extractTextMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_extractTextMenuItemActionPerformed
        new ExtractText().setVisible(true);
    }//GEN-LAST:event_extractTextMenuItemActionPerformed

    public static void main(String args[]) {
      
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StegoImage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StegoImage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StegoImage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StegoImage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StegoImage().setVisible(true);
            }
        });
    }
    
    private void applySinglePlaneBPCS() {
        if (originalImage != null) {
            currentImage = imageUtility.copyImage(originalImage);
            bitPlane.singlePlane(currentImage, bpcsIndex, pixelSize);
            imageLabel.setIcon(new ImageIcon(currentImage));
            int bitPlaneCode = bpcsIndex / 8;
            String bitPlaneName = "Alpha";
            
            // checking if alpha channel is absent
            if (pixelSize <= 24) {
                bitPlaneCode += 1;
            }
            switch(bitPlaneCode) {
                case 1: 
                    bitPlaneName = "Blue";
                    break;
                case 2:
                    bitPlaneName = "Green";
                    break;
                case 3:
                    bitPlaneName = "Red";
                    break;
            }
            nameLabel.setText(bitPlaneName + " plane: " + 
                    (7 - (bpcsIndex % 8)) + "th bit");
        }
    }
    
    private void manipulateImage() {
        if (bpcsIndex >= 0) {
            applySinglePlaneBPCS();
        } else if (bpcsIndex >= minBPCSIndex) {
            applyAllPlaneBPCS();
        }
    }
    
    private void applyAllPlaneBPCS() {
        if (originalImage != null) {
            currentImage = imageUtility.copyImage(originalImage);
            bitPlane.allPlane(currentImage, bpcsIndex, pixelSize);
            imageLabel.setIcon(new ImageIcon(currentImage));
            nameLabel.setText("All plane: " + ((bpcsIndex * -1) - 1) + "th bit");
        }
    }
    
    private void applyBitwiseXOR() {
        if (originalImage != null) {
            currentImage = imageUtility.copyImage(originalImage);
            bitwiseXOR.xor(currentImage, bitwiseXORIndex, pixelSize, nameLabel);
            imageLabel.setIcon(new ImageIcon(currentImage));
        }
    }
    
    private void printImageInfo(BufferedImage image) {
        System.out.println("Image Type: " + image.getType());
        ColorModel colorModel = image.getColorModel();
        pixelSize = colorModel.getPixelSize();
        System.out.println("Pixel size: " + pixelSize);

    }
    
    private void applyColourMap() {
        if (originalImage != null) {
            currentImage = imageUtility.copyImage(originalImage);
            currentImage = colourMap.changeColourMap(currentImage, 
                    customIndexColorModels[colourMapIndex]);
            if (currentImage != null) {
                nameLabel.setText("Colour Map: " + colourMapIndex);
                imageLabel.setIcon(new ImageIcon(currentImage));
            } else {
                nameLabel.setText("Not an indexed image");
            }
        }
    }
    
    private void otherManipulations() {
        if (originalImage == null) {
            return;
        }
        currentImage = imageUtility.copyImage(originalImage);
        switch (othersIndex) {
            case 1: {
                imageManipulation.convertToGrayscale(currentImage);
                nameLabel.setText("Grayscale");
                break;
            }
            case 2: {
                imageManipulation.invertImage(currentImage, pixelSize);
                nameLabel.setText("Inverted");
                break;
            }
        }
        imageLabel.setIcon(new ImageIcon(currentImage));
    }
    
    private void alert(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
    
    private void saveSteganoImage(BufferedImage steganoImage, 
            File steganoImageFile) {
        fileChooser.setDialogTitle("Choose a location");
        String oldFileName = steganoImageFile.getName();
        String newFileName = imageUtility.getNewFileName(oldFileName);
        String path = steganoImageFile.getAbsolutePath();
        path = path.substring(0, path.lastIndexOf(File.separator) + 1);
        File file = new File(path + newFileName);
        fileChooser.setSelectedFile(file);
        int returnVal = fileChooser.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
            String name = file.getName();
            if (imageUtility.isImage(name)) {
                imageUtility.saveImage(steganoImage, file);
            } else {
                alert("Invalid file name");
            }

        }
    }
    
    private void showThresholdFrame() {
        if (originalImage != null) {
            currentImage = imageUtility.copyImage(originalImage);
            ColorModel colorModel = currentImage.getColorModel();
            if (colorModel instanceof IndexColorModel) {
                nameLabel.setText("Not applicable for indexed image");
                return;
            }
            thresholdFrame.setBounds(0, 0, 400, 148);
            thresholdFrame.setVisible(true);
            currentImage = imageUtility.thresholdImage(currentImage, 50);
            imageLabel.setIcon(new ImageIcon(currentImage));
        }
    }
    
    private void printResizeImageInfo() {
        if (coverImage != null && targetImage != null) {
            int coverWidth = coverImage.getWidth();
            int coverHeight = coverImage.getHeight();
            int targetWidth = targetImage.getWidth();
            int targetHeight = targetImage.getHeight();
            if (coverWidth == targetWidth && coverHeight == targetHeight) {
                return;
            }
            alert("Dimensions not equal. Image(s) will be cropped");
            int requiredWidth = (coverWidth < targetWidth ? coverWidth :
                    targetWidth);
            int requiredHeight = (coverHeight < targetHeight ? coverHeight :
                    targetHeight);
            coverImage = 
                    imageUtility.cropImage(coverImage, requiredWidth, requiredHeight);
            targetImage = 
                    imageUtility.cropImage(targetImage, requiredWidth, requiredHeight);
            
        }
    }
    
    private void alert(String message, String title) {
        JTextArea textArea = new JTextArea(message);
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        scrollPane.setPreferredSize(new Dimension(500, 500));
        JOptionPane.showMessageDialog(null, scrollPane, title,
                JOptionPane.INFORMATION_MESSAGE);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu analyzeMenu;
    private javax.swing.JMenuItem appendedDataMenuItem;
    private javax.swing.JRadioButton bitPlaneRadioButton;
    private javax.swing.JRadioButton bitwiseXORRadioButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton chooseSourceImageButton;
    private javax.swing.JButton chooseTargetImageButton;
    private javax.swing.JRadioButton colourMapRadioButton;
    private javax.swing.JLabel coverImageLabel;
    private javax.swing.JLabel currentThresholdLabel;
    private javax.swing.JLabel currentValueLabel;
    private javax.swing.JLabel encryptionLabel;
    private javax.swing.JTextField encryptionTextField;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenuItem extractTextMenuItem;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenu hideDataMenu;
    private javax.swing.JButton hideImageButton;
    private javax.swing.JFrame hideImageFrame;
    private javax.swing.JMenuItem hideImageMenuItem;
    private javax.swing.JMenuItem hideTextMenuItem;
    private javax.swing.JComboBox imageEncryptionComboBox;
    private javax.swing.JComboBox imageHideMethodComboBox;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem metaDataMenuItem;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton nextButton;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JRadioButton othersRadioButton;
    private javax.swing.JMenuItem pngCheckMenuItem;
    private javax.swing.JButton previousButton;
    private javax.swing.JButton resetSelectionButton;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JLabel targetImageLabel;
    private javax.swing.JFrame thresholdFrame;
    private javax.swing.JMenu thresholdMenu;
    private javax.swing.JSlider thresholdSlider;
    // End of variables declaration//GEN-END:variables
}
