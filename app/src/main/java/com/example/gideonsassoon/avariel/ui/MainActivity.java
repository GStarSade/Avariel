package com.example.gideonsassoon.avariel.ui;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.gideonsassoon.avariel.R;
import com.example.gideonsassoon.avariel.datamodels.Sheet;
import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

public class MainActivity extends FragmentActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    MainFragmentAdaptor mMainFragmentAdaptor;

    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE};

    private Sheet sheet;
    private Realm realm;

    @BindView(R.id.viewpager)
    ViewPager mViewPager;
    @BindView(R.id.et_character_name)
    EditText et_character_name;
    @BindView(R.id.s_race)
    Spinner s_race;
    @BindView(R.id.s_alignment)
    Spinner s_alignment;
    @BindView(R.id.s_class)
    Spinner s_class;
    @BindView(R.id.et_current_hp)
    EditText et_current_hp;
    @BindView(R.id.et_total_hp)
    EditText et_total_hp;
    @BindView(R.id.et_exp)
    EditText et_exp;
    @BindView(R.id.tv_level_value)
    TextView tv_level_value;
    @BindView(R.id.et_strengthScore)
    EditText et_strengthScore;
    @BindView(R.id.et_dexterityScore)
    EditText et_dexterityScore;
    @BindView(R.id.et_constitutionScore)
    EditText et_constitutionScore;
    @BindView(R.id.et_intelligenceScore)
    EditText et_intelligenceScore;
    @BindView(R.id.et_wisdomScore)
    EditText et_wisdomScore;
    @BindView(R.id.et_charismaScore)
    EditText et_charismaScore;
    @BindView(R.id.tv_strength_mod)
    TextView tv_strength_mod;
    @BindView(R.id.tv_dexterity_mod)
    TextView tv_dexterity_mod;
    @BindView(R.id.tv_constitution_mod)
    TextView tv_constitution_mod;
    @BindView(R.id.tv_intelligence_mod)
    TextView tv_intelligence_mod;
    @BindView(R.id.tv_wisdom_mod)
    TextView tv_wisdom_mod;
    @BindView(R.id.tv_charisma_mod)
    TextView tv_charisma_mod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fragment);
        ButterKnife.bind(this);
        realm = Realm.getDefaultInstance();

        mMainFragmentAdaptor = new MainFragmentAdaptor(getSupportFragmentManager());
        mViewPager.setAdapter(mMainFragmentAdaptor);
        realm.where(Sheet.class).findAll().addChangeListener(new RealmChangeListener<RealmResults<Sheet>>() {
            @Override
            public void onChange(RealmResults<Sheet> sheets) {
                addPlayerToUI(sheets.first());
            }
        });

        et_character_name.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange characterName: " + hasFocus);
                if (!hasFocus) {
                    final String name = ((TextView) v).getText().toString();
                    try {
                        realm.executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {
                                sheet.setCharacterName(name);
                            }
                        });
                    } catch (Exception e) {
                        Log.e("REALM SET C NAME ERROR ", e.toString());
                    }
                }
            }
        });

        ArrayAdapter<CharSequence> raceAdapter = ArrayAdapter.createFromResource(this, R.array.race, android.R.layout.simple_spinner_dropdown_item);
        s_race.setAdapter(raceAdapter);
        s_race.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, final int position, long id) {
                Log.d(TAG, "onItemSelectedChange race: " + position);
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        Log.d(TAG, "onItemSelectedChange race execute " + position);
                        sheet.setRace(position);
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<CharSequence> playerClassAdapter = ArrayAdapter.createFromResource(this, R.array.player_class, android.R.layout.simple_spinner_dropdown_item);
        s_class.setAdapter(playerClassAdapter);
        s_class.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, final int position, long id) {
                Log.d(TAG, "onItemSelectedChange class: " + position);
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        Log.d(TAG, "onItemSelectedChange class execute " + position);
                        sheet.setPlayerClass(position);
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        ArrayAdapter<CharSequence> alignmentAdapter = ArrayAdapter.createFromResource(this, R.array.alignment, android.R.layout.simple_spinner_dropdown_item);
        s_alignment.setAdapter(alignmentAdapter);
        s_alignment.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, final int position, long id) {
                Log.d(TAG, "onItemSelectedChange alignment: " + position);
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        Log.d(TAG, "onItemSelectedChange alignment execute " + position);
                        sheet.setAlignment(position);
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        et_current_hp.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange currentHP: " + hasFocus);
                if (!hasFocus) {
                    final String currentHPString = ((EditText) v).getText().toString();
                    final int currentHP = Integer.parseInt(currentHPString);
                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            sheet.setCurrentHitPoints(currentHP);
                        }
                    });
                }
            }
        });

        et_total_hp.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange totalHP: " + hasFocus);
                if (!hasFocus) {
                    final String totalHPString = ((EditText) v).getText().toString();
                    final int totalHP = Integer.parseInt(totalHPString);
                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            sheet.setTotalHitPoints(totalHP);
                        }
                    });
                }
            }
        });

        et_exp.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange exp: " + hasFocus);
                if (!hasFocus) {
                    final String expString = ((EditText) v).getText().toString();
                    final int exp = Integer.parseInt(expString);
                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            sheet.setExperiencePoint(exp);
                        }
                    });
                    tv_level_value.setText((String.valueOf(sheet.getCurrentLevel())));
                }
            }
        });

        et_strengthScore.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange strength: " + hasFocus);
                if (!hasFocus) {
                    final String strengthScoreString = ((EditText) v).getText().toString();
                    final int strengthScore = Integer.parseInt(strengthScoreString);
                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            sheet.setStrengthScore(strengthScore);
                        }
                    });
                    tv_strength_mod.setText((String.valueOf(sheet.getStrengthModified())));
                }
            }
        });

        et_dexterityScore.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange dexterity: " + hasFocus);
                if (!hasFocus) {
                    final String dexterityScoreString = ((EditText) v).getText().toString();
                    final int dexterityScore = Integer.parseInt(dexterityScoreString);
                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            sheet.setDexterityScore(dexterityScore);
                        }
                    });
                    tv_dexterity_mod.setText((String.valueOf(sheet.getDexterityModified())));
                }
            }
        });

        et_constitutionScore.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange constitution: " + hasFocus);
                if (!hasFocus) {
                    final String constitutionScoreString = ((EditText) v).getText().toString();
                    final int constitutionScore = Integer.parseInt(constitutionScoreString);
                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            sheet.setConstitutionScore(constitutionScore);
                        }
                    });
                    tv_constitution_mod.setText((String.valueOf(sheet.getConstitutionModified())));
                }
            }
        });

        et_intelligenceScore.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange intelligence: " + hasFocus);
                if (!hasFocus) {
                    final String intelligenceScoreString = ((EditText) v).getText().toString();
                    final int intelligenceScore = Integer.parseInt(intelligenceScoreString);

                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            sheet.setIntelligenceScore(intelligenceScore);
                        }
                    });
                    tv_intelligence_mod.setText((String.valueOf(sheet.getIntelligenceModified())));
                }
            }
        });

        et_wisdomScore.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange wisdom: " + hasFocus);
                if (!hasFocus) {
                    final String wisdomScoreString = ((EditText) v).getText().toString();
                    final int wisdomScore = Integer.parseInt(wisdomScoreString);

                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            sheet.setWisdomScore(wisdomScore);
                        }
                    });
                    tv_wisdom_mod.setText((String.valueOf(sheet.getWisdomModified())));
                }
            }
        });

        et_charismaScore.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange charisma: " + hasFocus);
                if (!hasFocus) {
                    final String charismaScoreString = ((EditText) v).getText().toString();
                    final int charismaScore = Integer.parseInt(charismaScoreString);

                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            sheet.setCharismaScore(charismaScore);
                        }
                    });
                    tv_charisma_mod.setText((String.valueOf(sheet.getCharismaModified())));
                }
            }
        });

        playerInit();
        permissionRequest();
    }

    private void permissionRequest() {
        int permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permission != PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(this, PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
    }

    private void playerInit() {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Log.d("Avariel REALM SET", "Before create object");
                sheet = realm.where(Sheet.class).equalTo(Sheet.FIELD_SHEET_ID, 0).findFirst();
                if (sheet == null) {
                    sheet = new Sheet();
                    sheet.setSheetID(0);
                    sheet = realm.copyToRealm(sheet);
                }
                Log.i("Avariel REALM SET", "after create object");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        addPlayerToUI(sheet);
                    }
                });
            }
        });
    }

    void addPlayerToUI(Sheet sheet) {
        et_character_name.setText(sheet.getCharacterName());
        s_race.setSelection(sheet.getRaceInt());
        s_class.setSelection(sheet.getPlayerClassInt());
        s_alignment.setSelection(sheet.getAlignment());
        et_current_hp.setText(String.valueOf(sheet.getCurrentHitPoints()));
        et_total_hp.setText(String.valueOf(sheet.getTotalHitPoints()));
        et_exp.setText(String.valueOf(sheet.getExperiencePoint()));
        tv_level_value.setText(String.valueOf(sheet.getCurrentLevel()));

        et_strengthScore.setText((String.valueOf(sheet.getStrengthScore())));
        et_dexterityScore.setText((String.valueOf(sheet.getDexterityScore())));
        et_constitutionScore.setText((String.valueOf(sheet.getConstitutionScore())));
        et_intelligenceScore.setText((String.valueOf(sheet.getIntelligenceScore())));
        et_wisdomScore.setText((String.valueOf(sheet.getWisdomScore())));
        et_charismaScore.setText((String.valueOf(sheet.getCharismaScore())));

        tv_strength_mod.setText((String.valueOf(sheet.getStrengthModified())));
        tv_dexterity_mod.setText((String.valueOf(sheet.getDexterityModified())));
        tv_constitution_mod.setText((String.valueOf(sheet.getCharismaModified())));
        tv_intelligence_mod.setText((String.valueOf(sheet.getIntelligenceModified())));
        tv_wisdom_mod.setText((String.valueOf(sheet.getWisdomModified())));
        tv_charisma_mod.setText((String.valueOf(sheet.getCharismaModified())));
    }

    /***
     * Export save file of Realm
     * https://stackoverflow.com/questions/28478987/how-to-view-my-realm-file-in-the-realm-browser
     * https://developer.android.com/training/basics/data-storage/files.html#GetWritePermission
     * https://medium.com/glucosio-project/example-class-to-export-import-a-realm-database-on-android-c429ade2b4ed
     */
    void realmExport() {
        File exportRealmFile = null;
        try {
            String state = Environment.getExternalStorageState();
            if (Environment.MEDIA_MOUNTED.equals(state)) {
                exportRealmFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "export.realm");
                if (exportRealmFile.exists())
                    exportRealmFile.delete();
                realm.writeCopyTo(exportRealmFile);
            } else {
                throw new RuntimeException("Unable to mount External Storage for R+W");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        realmExport();
    }

    @Override
    public void onStop() {
        super.onStop();
        realmExport();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (realm != null) { // guard against weird low-budget phones
            realmExport();
            realm.close();
            realm = null;
        }
    }

    public Realm getRealm() {
        return realm;
    }
}