
=> Copy files - TensorFlowImageClassifier, Classifier, ClassifierActivity
   Copy folder - env helper folder - BorderedText, ImageUtils, Logger, Size, SplitTimer
   Copy assets - assets folder - graph.pb, labels.txt

------------------------------------------------------

=> In build.gradle projects, add this
project.buildDir = 'gradleBuild'
getProject().setBuildDir('gradleBuild')

project.ext.ASSET_DIR = projectDir.toString() + '/app/assets'

assert file(project.ext.ASSET_DIR + "/graph.pb").exists()
assert file(project.ext.ASSET_DIR + "/labels.txt").exists()

------------------------------------------------------
=> In build.gradle app, add this

dependencies {
    implementation 'org.tensorflow:tensorflow-android:+'
}

------------------------------------------------------

=> Static variables

    private static final int INPUT_SIZE = 224;
    private static final int IMAGE_MEAN = 128;
    private static final float IMAGE_STD = 128.0f;
    private static final String INPUT_NAME = "input";
    private static final String OUTPUT_NAME = "final_result";
    private static final String MODEL_FILE = "file:///android_asset/graph.pb";
    private static final String LABEL_FILE = "file:///android_asset/labels.txt";

------------------------------------------------------

=> Initialize Tensorflow Image Classifier

initTensorFlowAndLoadModel()

private void initTensorFlowAndLoadModel() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    classifier =
                            TensorFlowImageClassifier.create(
                                    getAssets(),
                                    MODEL_FILE,
                                    LABEL_FILE,
                                    INPUT_SIZE,
                                    IMAGE_MEAN,
                                    IMAGE_STD,
                                    INPUT_NAME,
                                    OUTPUT_NAME);
                } catch (final Exception e) {
                    throw new RuntimeException("Error initializing TensorFlow!", e);
                }
            }
        });
}

------------------------------------------------------

=> Resize bitmap image and use in classifier

Bitmap croppedBitmap = Bitmap.createScaledBitmap(bitmap, INPUT_SIZE, INPUT_SIZE, true);
final List<Classifier.Recognition> results = classifier.recognizeImage(croppedBitmap);
txtPreview.setText(results.toString());