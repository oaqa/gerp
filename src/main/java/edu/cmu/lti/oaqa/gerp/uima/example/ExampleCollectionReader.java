package edu.cmu.lti.oaqa.gerp.uima.example;

import java.io.IOException;

import org.apache.uima.cas.CAS;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.collection.CollectionReader_ImplBase;
import org.apache.uima.util.Progress;

public class ExampleCollectionReader extends CollectionReader_ImplBase {

  private boolean hasNext = true;

  @Override
  public void getNext(CAS cas) throws IOException, CollectionException {
    cas.setDocumentText("This is a normal English sentence.\nX52aQhBP8ouH7RvpYFeBiL1wtSj5ZSNOjs1gHNTC");
    hasNext = false;
  }

  @Override
  public boolean hasNext() throws IOException, CollectionException {
    return hasNext;
  }

  @Override
  public Progress[] getProgress() {
    return null;
  }

  @Override
  public void close() throws IOException {
  }

}