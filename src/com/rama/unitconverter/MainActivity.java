package com.rama.unitconverter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.rama.method.AngleMethod;
import com.rama.method.AreaMethod;
import com.rama.method.DatastorageMethod;
import com.rama.method.EneryMethod;
import com.rama.method.LenthMethod;
import com.rama.method.TempatureMetho;
import com.rama.method.TimeItemMethod;

public class MainActivity extends Activity {

	Spinner selectType, spOne, spTwo;
	EditText firstOut, secondOut;
	TextView ls;
	ArrayAdapter<String> mainAdapter;
	ArrayAdapter<String> firstAdapter;
	ArrayAdapter<String> secondAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// requestWindowFeature(Window.FEATURE_NO_TITLE);
		// this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
		// WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.activity_main);

		selectType = (Spinner) findViewById(R.id.spSelector);
		firstOut = (EditText) findViewById(R.id.etItem1);
		secondOut = (EditText) findViewById(R.id.etItem2);
		spOne = (Spinner) findViewById(R.id.spConvert1);
		spTwo = (Spinner) findViewById(R.id.spConvert2);

		mainAdapter = new ArrayAdapter<String>(this,
				R.layout.single_patern,R.id.txt, getResources()
						.getStringArray(R.array.ConvertItem));
		selectType.setAdapter(mainAdapter);

		selectType.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View v,
					int position, long id) {
				switch (position) {
				case 0:
					firstAdapter = new ArrayAdapter<String>(MainActivity.this,
							R.layout.duel_patern,R.id.setText,
							getResources().getStringArray(R.array.AngleItem));
					spOne.setAdapter(firstAdapter);
					secondAdapter = new ArrayAdapter<String>(MainActivity.this,
							R.layout.duel_patern,R.id.setText,
							getResources().getStringArray(R.array.AngleItem));
					spTwo.setAdapter(secondAdapter);
					break;
				case 1:
					firstAdapter = new ArrayAdapter<String>(MainActivity.this,
							R.layout.duel_patern,R.id.setText,
							getResources().getStringArray(R.array.AreaItem));
					
					spOne.setAdapter(firstAdapter);
					secondAdapter = new ArrayAdapter<String>(MainActivity.this,
							R.layout.duel_patern,R.id.setText,
							getResources().getStringArray(R.array.AreaItem));
					spTwo.setAdapter(secondAdapter);
					break;

				case 2:
					firstAdapter = new ArrayAdapter<String>(MainActivity.this,
							R.layout.duel_patern,R.id.setText,
							getResources().getStringArray(R.array.DigitalItem));
					spOne.setAdapter(firstAdapter);
					secondAdapter = new ArrayAdapter<String>(MainActivity.this,
							R.layout.duel_patern,R.id.setText,
							getResources().getStringArray(R.array.DigitalItem));
					spTwo.setAdapter(secondAdapter);
					break;
				case 3:
					firstAdapter = new ArrayAdapter<String>(MainActivity.this,
							R.layout.duel_patern,R.id.setText,
							getResources().getStringArray(R.array.EnergyItem));
					spOne.setAdapter(firstAdapter);
					secondAdapter = new ArrayAdapter<String>(MainActivity.this,
							R.layout.duel_patern,R.id.setText,
							getResources().getStringArray(R.array.EnergyItem));
					spTwo.setAdapter(secondAdapter);
					break;
				case 4:
					firstAdapter = new ArrayAdapter<String>(MainActivity.this,
							R.layout.duel_patern,R.id.setText,
							getResources().getStringArray(R.array.LengthItem));
					spOne.setAdapter(firstAdapter);
					secondAdapter = new ArrayAdapter<String>(MainActivity.this,
							R.layout.duel_patern,R.id.setText,
							getResources().getStringArray(R.array.LengthItem));
					spTwo.setAdapter(secondAdapter);
					break;
				case 5:
					firstAdapter = new ArrayAdapter<String>(MainActivity.this,
							R.layout.duel_patern,R.id.setText,
							getResources()
									.getStringArray(R.array.TempatureItem));
					spOne.setAdapter(firstAdapter);
					secondAdapter = new ArrayAdapter<String>(MainActivity.this,
							R.layout.duel_patern,R.id.setText,
							getResources()
									.getStringArray(R.array.TempatureItem));
					spTwo.setAdapter(secondAdapter);
					break;
				case 6:
					firstAdapter = new ArrayAdapter<String>(MainActivity.this,
							R.layout.duel_patern,R.id.setText,
							getResources().getStringArray(R.array.TimeItem));
					spOne.setAdapter(firstAdapter);
					secondAdapter = new ArrayAdapter<String>(MainActivity.this,
							R.layout.duel_patern,R.id.setText,
							getResources().getStringArray(R.array.TimeItem));
					spTwo.setAdapter(secondAdapter);
					break;
				default:
					break;
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {

			}
		});
	}

	public void clear(View v) {
		firstOut.setText("");
		secondOut.setText("");
	}

	public void swap(View v) {
		String first = firstOut.getText().toString();
		String second = secondOut.getText().toString();
		firstOut.setText(second);
		secondOut.setText(first);

		int list1 = spOne.getSelectedItemPosition();
		int list2 = spTwo.getSelectedItemPosition();

		spOne.setSelection(list2);
		spTwo.setSelection(list1);

	}

	public void convert(View v) {
		String str = firstOut.getText().toString();
		Object selector = selectType.getSelectedItem();

		if (!str.equals("")) {
			if ("Time".equals(selector)) {
				// ....set time method...
				
				setTimeOperation();

			} else if ("Tempature".equals(selector)) {
				// .....set temperature method...
				setTempetureOperation();

			} else if ("Digital Storage".equals(selector)) {
				// ....set digital storage method...
				setDigitalStorageOperation();

			} else if ("Length".equals(selector)) {
				// ....set Length method...
				setLengthOperation();

			} else if ("Angle".equals(selector)) {
				// ....set angle method...
				setAngleOperation();

			} else if ("Area".equals(selector)) {
				// ....set Area method...
				setAreaOperation();

			} else if ("Energy".equals(selector)) {
				// ....set Energy method....
				setEnergyOperation();

			}
		} else {
			Toast.makeText(getApplicationContext(), "Require input",
					Toast.LENGTH_LONG).show();
		}
	}

	private void setAreaOperation() {
		String str = firstOut.getText().toString();
		double value = Double.valueOf(str);

		if ("square km".equals(spOne.getSelectedItem())
				&& "square km".equals(spTwo.getSelectedItem())) {
			String result = AreaMethod.SquareKToSquareK(value);
			secondOut.setText(result);
		} else if ("square km".equals(spOne.getSelectedItem())
				&& "Hectare".equals(spTwo.getSelectedItem())) {
			String result = AreaMethod.SquareKToHectare(value);
			secondOut.setText(result);
		} else if ("square km".equals(spOne.getSelectedItem())
				&& "square meter".equals(spTwo.getSelectedItem())) {
			String result = AreaMethod.SquareKToskmeter(value);
			secondOut.setText(result);
		} else if ("square km".equals(spOne.getSelectedItem())
				&& "square mile".equals(spTwo.getSelectedItem())) {
			String result = AreaMethod.SquareKToMIle(value);
			secondOut.setText(result);
		} else if ("square km".equals(spOne.getSelectedItem())
				&& "acre".equals(spTwo.getSelectedItem())) {
			String result = AreaMethod.SquareKToAcre(value);
			secondOut.setText(result);
		} else if ("square km".equals(spOne.getSelectedItem())
				&& "square yard".equals(spTwo.getSelectedItem())) {
			String result = AreaMethod.SquareKToYard(value);
			secondOut.setText(result);
		}

		else if ("Hectare".equals(spOne.getSelectedItem())
				&& "square km".equals(spTwo.getSelectedItem())) {
			String result = AreaMethod.HectareToSquareK(value);
			secondOut.setText(result);
		} else if ("Hectare".equals(spOne.getSelectedItem())
				&& "Hectare".equals(spTwo.getSelectedItem())) {
			String result = AreaMethod.HectareToHectare(value);
			secondOut.setText(result);
		} else if ("Hectare".equals(spOne.getSelectedItem())
				&& "square meter".equals(spTwo.getSelectedItem())) {
			String result = AreaMethod.HectareToSmeter(value);
			secondOut.setText(result);
		} else if ("Hectare".equals(spOne.getSelectedItem())
				&& "square mile".equals(spTwo.getSelectedItem())) {
			String result = AreaMethod.HectareToMIle(value);
			secondOut.setText(result);
		} else if ("Hectare".equals(spOne.getSelectedItem())
				&& "acre".equals(spTwo.getSelectedItem())) {
			String result = AreaMethod.HectareToAcre(value);
			secondOut.setText(result);
		} else if ("Hectare".equals(spOne.getSelectedItem())
				&& "square yard".equals(spTwo.getSelectedItem())) {
			String result = AreaMethod.HectareToYard(value);
			secondOut.setText(result);
		}

		else if ("square meter".equals(spOne.getSelectedItem())
				&& "square km".equals(spTwo.getSelectedItem())) {
			String result = AreaMethod.SMeterToSquareK(value);
			secondOut.setText(result);
		} else if ("square meter".equals(spOne.getSelectedItem())
				&& "Hectare".equals(spTwo.getSelectedItem())) {
			String result = AreaMethod.SMeterToHectare(value);
			secondOut.setText(result);
		} else if ("square meter".equals(spOne.getSelectedItem())
				&& "square meter".equals(spTwo.getSelectedItem())) {
			String result = AreaMethod.SMeterToSMeter(value);
			secondOut.setText(result);
		} else if ("square meter".equals(spOne.getSelectedItem())
				&& "square mile".equals(spTwo.getSelectedItem())) {
			String result = AreaMethod.SMeterToMIle(value);
			secondOut.setText(result);
		} else if ("square meter".equals(spOne.getSelectedItem())
				&& "acre".equals(spTwo.getSelectedItem())) {
			String result = AreaMethod.SMeterToAcre(value);
			secondOut.setText(result);
		} else if ("square meter".equals(spOne.getSelectedItem())
				&& "square yard".equals(spTwo.getSelectedItem())) {
			String result = AreaMethod.SMeterToYard(value);
			secondOut.setText(result);
		}

		else if ("square mile".equals(spOne.getSelectedItem())
				&& "square km".equals(spTwo.getSelectedItem())) {
			String result = AreaMethod.SMileToSquareK(value);
			secondOut.setText(result);
		} else if ("square mile".equals(spOne.getSelectedItem())
				&& "Hectare".equals(spTwo.getSelectedItem())) {
			String result = AreaMethod.SMileToHectare(value);
			secondOut.setText(result);
		} else if ("square mile".equals(spOne.getSelectedItem())
				&& "square meter".equals(spTwo.getSelectedItem())) {
			String result = AreaMethod.SMileToSMiter(value);
			secondOut.setText(result);
		} else if ("square mile".equals(spOne.getSelectedItem())
				&& "square mile".equals(spTwo.getSelectedItem())) {
			String result = AreaMethod.SMileToSMile(value);
			secondOut.setText(result);
		} else if ("square mile".equals(spOne.getSelectedItem())
				&& "acre".equals(spTwo.getSelectedItem())) {
			String result = AreaMethod.SMileToAcre(value);
			secondOut.setText(result);
		} else if ("square mile".equals(spOne.getSelectedItem())
				&& "square yard".equals(spTwo.getSelectedItem())) {
			String result = AreaMethod.SMileToYard(value);
			secondOut.setText(result);
		}

		else if ("acre".equals(spOne.getSelectedItem())
				&& "square km".equals(spTwo.getSelectedItem())) {
			String result = AreaMethod.AcreToSquareK(value);
			secondOut.setText(result);
		} else if ("acre".equals(spOne.getSelectedItem())
				&& "Hectare".equals(spTwo.getSelectedItem())) {
			String result = AreaMethod.AcreToHectare(value);
			secondOut.setText(result);
		} else if ("acre".equals(spOne.getSelectedItem())
				&& "square meter".equals(spTwo.getSelectedItem())) {
			String result = AreaMethod.AcreToSMiter(value);
			secondOut.setText(result);
		} else if ("acre".equals(spOne.getSelectedItem())
				&& "square mile".equals(spTwo.getSelectedItem())) {
			String result = AreaMethod.AcreToSMile(value);
			secondOut.setText(result);
		} else if ("acre".equals(spOne.getSelectedItem())
				&& "acre".equals(spTwo.getSelectedItem())) {
			String result = AreaMethod.AcreToAcre(value);
			secondOut.setText(result);
		} else if ("acre".equals(spOne.getSelectedItem())
				&& "square yard".equals(spTwo.getSelectedItem())) {
			String result = AreaMethod.AcreToYard(value);
			secondOut.setText(result);
		}

		else if ("square yard".equals(spOne.getSelectedItem())
				&& "square km".equals(spTwo.getSelectedItem())) {
			String result = AreaMethod.SyardToSquareK(value);
			secondOut.setText(result);
		} else if ("square yard".equals(spOne.getSelectedItem())
				&& "Hectare".equals(spTwo.getSelectedItem())) {
			String result = AreaMethod.SyardToHectare(value);
			secondOut.setText(result);
		} else if ("square yard".equals(spOne.getSelectedItem())
				&& "square meter".equals(spTwo.getSelectedItem())) {
			String result = AreaMethod.SyardToSMiter(value);
			secondOut.setText(result);
		} else if ("square yard".equals(spOne.getSelectedItem())
				&& "square mile".equals(spTwo.getSelectedItem())) {
			String result = AreaMethod.SyardToSMile(value);
			secondOut.setText(result);
		} else if ("square yard".equals(spOne.getSelectedItem())
				&& "acre".equals(spTwo.getSelectedItem())) {
			String result = AreaMethod.SyardToAcre(value);
			secondOut.setText(result);
		} else if ("square yard".equals(spOne.getSelectedItem())
				&& "square yard".equals(spTwo.getSelectedItem())) {
			String result = AreaMethod.SyardToSyard(value);
			secondOut.setText(result);
		}
	}

	private void setEnergyOperation() {

		String str = firstOut.getText().toString();
		double value = Double.valueOf(str);

		if ("calorie(cal)".equals(spOne.getSelectedItem())
				&& "calorie(cal)".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.calorieTocalorie(value);
			secondOut.setText(result);
		} else if ("calorie(cal)".equals(spOne.getSelectedItem())
				&& "electronvolt(eV)".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.calorieToelectronvolt(value);
			secondOut.setText(result);
		} else if ("calorie(cal)".equals(spOne.getSelectedItem())
				&& "foot-pound".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.calorieTofoot_pound(value);
			secondOut.setText(result);
		} else if ("calorie(cal)".equals(spOne.getSelectedItem())
				&& "gigajoule".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.calorieTogigajoule(value);
			secondOut.setText(result);
		} else if ("calorie(cal)".equals(spOne.getSelectedItem())
				&& "joule(J)".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.calorieTojoule(value);
			secondOut.setText(result);
		} else if ("calorie(cal)".equals(spOne.getSelectedItem())
				&& "kilocalorie".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.calorieTokilocalorie(value);
			secondOut.setText(result);
		} else if ("calorie(cal)".equals(spOne.getSelectedItem())
				&& "kilowatt hou(kWh)".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.calorieTokilowatt(value);
			secondOut.setText(result);
		} else if ("calorie(cal)".equals(spOne.getSelectedItem())
				&& "megajoule(mj)".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.calorieTomegajoule(value);
			secondOut.setText(result);
		} else if ("calorie(cal)".equals(spOne.getSelectedItem())
				&& "watt hour (Wh)".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.calorieTowatt_hour(value);
			secondOut.setText(result);
		}

		else if ("electronvolt(eV)".equals(spOne.getSelectedItem())
				&& "calorie(cal)".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.electronvoltTocalorie(value);
			secondOut.setText(result);
		} else if ("electronvolt(eV)".equals(spOne.getSelectedItem())
				&& "electronvolt(eV)".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.electronvoltToelectronvolt(value);
			secondOut.setText(result);
		} else if ("electronvolt(eV)".equals(spOne.getSelectedItem())
				&& "foot-pound".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.electronvoltTofoot_pound(value);
			secondOut.setText(result);
		} else if ("electronvolt(eV)".equals(spOne.getSelectedItem())
				&& "gigajoule".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.electronvoltTogigajoule(value);
			secondOut.setText(result);
		} else if ("electronvolt(eV)".equals(spOne.getSelectedItem())
				&& "joule(J)".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.electronvoltTojoule(value);
			secondOut.setText(result);
		} else if ("electronvolt(eV)".equals(spOne.getSelectedItem())
				&& "kilocalorie".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.electronvoltTokilocalorie(value);
			secondOut.setText(result);
		} else if ("electronvolt(eV)".equals(spOne.getSelectedItem())
				&& "kilowatt hou(kWh)".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.electronvoltTokilowatt(value);
			secondOut.setText(result);
		} else if ("electronvolt(eV)".equals(spOne.getSelectedItem())
				&& "megajoule(mj)".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.electronvoltTomegajoule(value);
			secondOut.setText(result);
		} else if ("electronvolt(eV)".equals(spOne.getSelectedItem())
				&& "watt hour (Wh)".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.electronvoltTowatt_hour(value);
			secondOut.setText(result);
		}

		else if ("foot-pound".equals(spOne.getSelectedItem())
				&& "calorie(cal)".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.foot_poundTocalorie(value);
			secondOut.setText(result);
		} else if ("foot-pound".equals(spOne.getSelectedItem())
				&& "electronvolt(eV)".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.foot_poundToelectronvolt(value);
			secondOut.setText(result);
		} else if ("foot-pound".equals(spOne.getSelectedItem())
				&& "foot-pound".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.foot_poundTofoot_pound(value);
			secondOut.setText(result);
		} else if ("foot-pound".equals(spOne.getSelectedItem())
				&& "gigajoule".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.foot_poundTogigajoule(value);
			secondOut.setText(result);
		} else if ("foot-pound".equals(spOne.getSelectedItem())
				&& "joule(J)".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.foot_poundTojoule(value);
			secondOut.setText(result);
		} else if ("foot-pound".equals(spOne.getSelectedItem())
				&& "kilocalorie".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.foot_poundTokilocalorie(value);
			secondOut.setText(result);
		} else if ("foot-pound".equals(spOne.getSelectedItem())
				&& "kilowatt hou(kWh)".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.foot_poundTokilowatt(value);
			secondOut.setText(result);
		} else if ("foot-pound".equals(spOne.getSelectedItem())
				&& "megajoule(mj)".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.foot_poundTomegajoule(value);
			secondOut.setText(result);
		} else if ("foot-pound".equals(spOne.getSelectedItem())
				&& "watt hour (Wh)".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.foot_poundTowatt_hour(value);
			secondOut.setText(result);
		}

		else if ("gigajoule".equals(spOne.getSelectedItem())
				&& "calorie(cal)".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.gigajouleTocalorie(value);
			secondOut.setText(result);
		} else if ("gigajoule".equals(spOne.getSelectedItem())
				&& "electronvolt(eV)".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.gigajouleToelectronvolt(value);
			secondOut.setText(result);
		} else if ("gigajoule".equals(spOne.getSelectedItem())
				&& "foot-pound".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.gigajouleTofoot_pound(value);
			secondOut.setText(result);
		} else if ("gigajoule".equals(spOne.getSelectedItem())
				&& "gigajoule".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.gigajouleTogigajoule(value);
			secondOut.setText(result);
		} else if ("gigajoule".equals(spOne.getSelectedItem())
				&& "joule(J)".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.gigajouleTojoule(value);
			secondOut.setText(result);
		} else if ("gigajoule".equals(spOne.getSelectedItem())
				&& "kilocalorie".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.gigajouleTokilocalorie(value);
			secondOut.setText(result);
		} else if ("gigajoule".equals(spOne.getSelectedItem())
				&& "kilowatt hou(kWh)".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.gigajouleTokilowatt(value);
			secondOut.setText(result);
		} else if ("gigajoule".equals(spOne.getSelectedItem())
				&& "megajoule(mj)".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.gigajouleTomegajoule(value);
			secondOut.setText(result);
		} else if ("gigajoule".equals(spOne.getSelectedItem())
				&& "watt hour (Wh)".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.gigajouleTowatt_hour(value);
			secondOut.setText(result);
		}

		else if ("joule(J)".equals(spOne.getSelectedItem())
				&& "calorie(cal)".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.jouleTocalorie(value);
			secondOut.setText(result);
		} else if ("joule(J)".equals(spOne.getSelectedItem())
				&& "electronvolt(eV)".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.jouleToelectronvolt(value);
			secondOut.setText(result);
		} else if ("joule(J)".equals(spOne.getSelectedItem())
				&& "foot-pound".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.jouleTofoot_pound(value);
			secondOut.setText(result);
		} else if ("joule(J)".equals(spOne.getSelectedItem())
				&& "gigajoule".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.jouleTogigajoule(value);
			secondOut.setText(result);
		} else if ("joule(J)".equals(spOne.getSelectedItem())
				&& "joule(J)".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.jouleTojoule(value);
			secondOut.setText(result);
		} else if ("joule(J)".equals(spOne.getSelectedItem())
				&& "kilocalorie".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.jouleTokilocalorie(value);
			secondOut.setText(result);
		} else if ("joule(J)".equals(spOne.getSelectedItem())
				&& "kilowatt hou(kWh)".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.jouleTokilowatt(value);
			secondOut.setText(result);
		} else if ("joule(J)".equals(spOne.getSelectedItem())
				&& "megajoule(mj)".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.jouleTomegajoule(value);
			secondOut.setText(result);
		} else if ("joule(J)".equals(spOne.getSelectedItem())
				&& "watt hour (Wh)".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.jouleTowatt_hour(value);
			secondOut.setText(result);
		}

		else if ("kilocalorie".equals(spOne.getSelectedItem())
				&& "calorie(cal)".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.kilocalorieTocalorie(value);
			secondOut.setText(result);
		} else if ("kilocalorie".equals(spOne.getSelectedItem())
				&& "electronvolt(eV)".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.kilocalorieToelectronvolt(value);
			secondOut.setText(result);
		} else if ("kilocalorie".equals(spOne.getSelectedItem())
				&& "foot-pound".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.kilocalorieTofoot_pound(value);
			secondOut.setText(result);
		} else if ("kilocalorie".equals(spOne.getSelectedItem())
				&& "gigajoule".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.kilocalorieTogigajoule(value);
			secondOut.setText(result);
		} else if ("kilocalorie".equals(spOne.getSelectedItem())
				&& "joule(J)".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.kilocalorieTojoule(value);
			secondOut.setText(result);
		} else if ("kilocalorie".equals(spOne.getSelectedItem())
				&& "kilocalorie".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.kilocalorieTokilocalorie(value);
			secondOut.setText(result);
		} else if ("kilocalorie".equals(spOne.getSelectedItem())
				&& "kilowatt hou(kWh)".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.kilocalorieTokilowatt(value);
			secondOut.setText(result);
		} else if ("kilocalorie".equals(spOne.getSelectedItem())
				&& "megajoule(mj)".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.kilocalorieTomegajoule(value);
			secondOut.setText(result);
		} else if ("kilocalorie".equals(spOne.getSelectedItem())
				&& "watt hour (Wh)".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.kilocalorieTowatt_hour(value);
			secondOut.setText(result);
		}

		else if ("kilowatt hou(kWh)".equals(spOne.getSelectedItem())
				&& "calorie(cal)".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.kilowattTocalorie(value);
			secondOut.setText(result);
		} else if ("kilowatt hou(kWh)".equals(spOne.getSelectedItem())
				&& "electronvolt(eV)".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.kilowattToelectronvolt(value);
			secondOut.setText(result);
		} else if ("kilowatt hou(kWh)".equals(spOne.getSelectedItem())
				&& "foot-pound".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.kilowattTofoot_pound(value);
			secondOut.setText(result);
		} else if ("kilowatt hou(kWh)".equals(spOne.getSelectedItem())
				&& "gigajoule".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.kilowattTogigajoule(value);
			secondOut.setText(result);
		} else if ("kilowatt hou(kWh)".equals(spOne.getSelectedItem())
				&& "joule(J)".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.kilowattTojoule(value);
			secondOut.setText(result);
		} else if ("kilowatt hou(kWh)".equals(spOne.getSelectedItem())
				&& "kilocalorie".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.kilowattTokilocalorie(value);
			secondOut.setText(result);
		} else if ("kilowatt hou(kWh)".equals(spOne.getSelectedItem())
				&& "kilowatt hou(kWh)".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.kilowattTokilowatt(value);
			secondOut.setText(result);
		} else if ("kilowatt hou(kWh)".equals(spOne.getSelectedItem())
				&& "megajoule(mj)".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.kilowattTomegajoule(value);
			secondOut.setText(result);
		} else if ("kilowatt hou(kWh)".equals(spOne.getSelectedItem())
				&& "watt hour (Wh)".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.kilowattTowatt_hour(value);
			secondOut.setText(result);
		}

		else if ("megajoule(mj)".equals(spOne.getSelectedItem())
				&& "calorie(cal)".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.megajouleTocalorie(value);
			secondOut.setText(result);
		} else if ("megajoule(mj)".equals(spOne.getSelectedItem())
				&& "electronvolt(eV)".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.megajouleToelectronvolt(value);
			secondOut.setText(result);
		} else if ("megajoule(mj)".equals(spOne.getSelectedItem())
				&& "foot-pound".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.megajouleTofoot_pound(value);
			secondOut.setText(result);
		} else if ("megajoule(mj)".equals(spOne.getSelectedItem())
				&& "gigajoule".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.megajouleTogigajoule(value);
			secondOut.setText(result);
		} else if ("megajoule(mj)".equals(spOne.getSelectedItem())
				&& "joule(J)".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.megajouleTojoule(value);
			secondOut.setText(result);
		} else if ("megajoule(mj)".equals(spOne.getSelectedItem())
				&& "kilocalorie".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.megajouleTokilocalorie(value);
			secondOut.setText(result);
		} else if ("megajoule(mj)".equals(spOne.getSelectedItem())
				&& "kilowatt hou(kWh)".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.megajouleTokilowatt(value);
			secondOut.setText(result);
		} else if ("megajoule(mj)".equals(spOne.getSelectedItem())
				&& "megajoule(mj)".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.megajouleTomegajoule(value);
			secondOut.setText(result);
		} else if ("megajoule(mj)".equals(spOne.getSelectedItem())
				&& "watt hour (Wh)".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.megajouleTowatt_hour(value);
			secondOut.setText(result);
		}

		else if ("watt hour (Wh)".equals(spOne.getSelectedItem())
				&& "calorie(cal)".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.watt_hourTocalorie(value);
			secondOut.setText(result);
		} else if ("watt hour (Wh)".equals(spOne.getSelectedItem())
				&& "electronvolt(eV)".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.watt_hourToelectronvolt(value);
			secondOut.setText(result);
		} else if ("watt hour (Wh)".equals(spOne.getSelectedItem())
				&& "foot-pound".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.watt_hourTofoot_pound(value);
			secondOut.setText(result);
		} else if ("kilocawatt hour (Wh)lorie".equals(spOne.getSelectedItem())
				&& "gigajoule".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.watt_hourTogigajoule(value);
			secondOut.setText(result);
		} else if ("watt hour (Wh)".equals(spOne.getSelectedItem())
				&& "joule(J)".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.watt_hourTojoule(value);
			secondOut.setText(result);
		} else if ("watt hour (Wh)".equals(spOne.getSelectedItem())
				&& "kilocalorie".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.watt_hourTokilocalorie(value);
			secondOut.setText(result);
		} else if ("watt hour (Wh)".equals(spOne.getSelectedItem())
				&& "kilowatt hou(kWh)".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.watt_hourTokilowatt(value);
			secondOut.setText(result);
		} else if ("watt hour (Wh)".equals(spOne.getSelectedItem())
				&& "megajoule(mj)".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.watt_hourTomegajoule(value);
			secondOut.setText(result);
		} else if ("watt hour (Wh)".equals(spOne.getSelectedItem())
				&& "watt hour (Wh)".equals(spTwo.getSelectedItem())) {
			String result = EneryMethod.watt_hourTowatt_hour(value);
			secondOut.setText(result);
		}

	}

	private void setAngleOperation() {

		String str = firstOut.getText().toString();
		double value = Double.valueOf(str);

		if ("degree".equals(spOne.getSelectedItem())
				&& "degree".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.DegreeToDree(value);
			secondOut.setText(result);
		} else if ("degree".equals(spOne.getSelectedItem())
				&& "radian".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.DegreeToRadian(value);
			secondOut.setText(result);
		} else if ("degree".equals(spOne.getSelectedItem())
				&& "grad".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.DegreeToGrad(value);
			secondOut.setText(result);
		} else if ("degree".equals(spOne.getSelectedItem())
				&& "minute".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.DegreeToMinute(value);
			secondOut.setText(result);
		} else if ("degree".equals(spOne.getSelectedItem())
				&& "second".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.DegreeToSecond(value);
			secondOut.setText(result);
		} else if ("degree".equals(spOne.getSelectedItem())
				&& "sign".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.DegreeToSign(value);
			secondOut.setText(result);
		} else if ("degree".equals(spOne.getSelectedItem())
				&& "mil".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.DegreeToMil(value);
			secondOut.setText(result);
		} else if ("degree".equals(spOne.getSelectedItem())
				&& "revolution".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.DegreeToRevolution(value);
			secondOut.setText(result);
		} else if ("degree".equals(spOne.getSelectedItem())
				&& "quadrant".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.DegreeToQuand(value);
			secondOut.setText(result);
		}

		else if ("radian".equals(spOne.getSelectedItem())
				&& "degree".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.DegreeToDree(value);
			secondOut.setText(result);
		} else if ("radian".equals(spOne.getSelectedItem())
				&& "radian".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.RadianToRadian(value);
			secondOut.setText(result);
		} else if ("radian".equals(spOne.getSelectedItem())
				&& "grad".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.RadianToGrad(value);
			secondOut.setText(result);
		} else if ("radian".equals(spOne.getSelectedItem())
				&& "minute".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.RadianToMinute(value);
			secondOut.setText(result);
		} else if ("radian".equals(spOne.getSelectedItem())
				&& "second".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.RadianToSecond(value);
			secondOut.setText(result);
		} else if ("radian".equals(spOne.getSelectedItem())
				&& "sign".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.RadianToSign(value);
			secondOut.setText(result);
		} else if ("radian".equals(spOne.getSelectedItem())
				&& "mil".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.RadianToMil(value);
			secondOut.setText(result);
		} else if ("radian".equals(spOne.getSelectedItem())
				&& "revolution".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.RadianToRevolution(value);
			secondOut.setText(result);
		} else if ("radian".equals(spOne.getSelectedItem())
				&& "quadrant".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.RadianToQuand(value);
			secondOut.setText(result);
		}

		else if ("grad".equals(spOne.getSelectedItem())
				&& "degree".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.GradToDegree(value);
			secondOut.setText(result);
		} else if ("grad".equals(spOne.getSelectedItem())
				&& "radian".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.GradToRadian(value);
			secondOut.setText(result);
		} else if ("grad".equals(spOne.getSelectedItem())
				&& "grad".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.GradToGrad(value);
			secondOut.setText(result);
		} else if ("grad".equals(spOne.getSelectedItem())
				&& "minute".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.GradToMinute(value);
			secondOut.setText(result);
		} else if ("grad".equals(spOne.getSelectedItem())
				&& "second".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.GradToSecond(value);
			secondOut.setText(result);
		} else if ("grad".equals(spOne.getSelectedItem())
				&& "sign".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.GradToSign(value);
			secondOut.setText(result);
		} else if ("grad".equals(spOne.getSelectedItem())
				&& "mil".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.GradToMil(value);
			secondOut.setText(result);
		} else if ("grad".equals(spOne.getSelectedItem())
				&& "revolution".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.GradToRevolution(value);
			secondOut.setText(result);
		} else if ("grad".equals(spOne.getSelectedItem())
				&& "quadrant".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.GradToQuand(value);
			secondOut.setText(result);
		}

		else if ("minute".equals(spOne.getSelectedItem())
				&& "degree".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.MinuteToDegree(value);
			secondOut.setText(result);
		} else if ("minute".equals(spOne.getSelectedItem())
				&& "radian".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.MinuteToRadian(value);
			secondOut.setText(result);
		} else if ("minute".equals(spOne.getSelectedItem())
				&& "grad".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.MinuteToGrad(value);
			secondOut.setText(result);
		} else if ("minute".equals(spOne.getSelectedItem())
				&& "minute".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.MinuteToMinute(value);
			secondOut.setText(result);
		} else if ("minute".equals(spOne.getSelectedItem())
				&& "second".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.MinuteToSecond(value);
			secondOut.setText(result);
		} else if ("minute".equals(spOne.getSelectedItem())
				&& "sign".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.MinuteToSign(value);
			secondOut.setText(result);
		} else if ("minute".equals(spOne.getSelectedItem())
				&& "mil".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.MinuteToMil(value);
			secondOut.setText(result);
		} else if ("minute".equals(spOne.getSelectedItem())
				&& "revolution".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.MinuteToRevolution(value);
			secondOut.setText(result);
		} else if ("minute".equals(spOne.getSelectedItem())
				&& "quadrant".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.MinuteToQuand(value);
			secondOut.setText(result);
		}

		else if ("second".equals(spOne.getSelectedItem())
				&& "degree".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.SecondToDegree(value);
			secondOut.setText(result);
		} else if ("second".equals(spOne.getSelectedItem())
				&& "radian".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.SecondToRadian(value);
			secondOut.setText(result);
		} else if ("second".equals(spOne.getSelectedItem())
				&& "grad".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.SecondToGrad(value);
			secondOut.setText(result);
		} else if ("second".equals(spOne.getSelectedItem())
				&& "minute".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.SecondToMinute(value);
			secondOut.setText(result);
		} else if ("second".equals(spOne.getSelectedItem())
				&& "second".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.SecondToSecond(value);
			secondOut.setText(result);
		} else if ("second".equals(spOne.getSelectedItem())
				&& "sign".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.SecondToSign(value);
			secondOut.setText(result);
		} else if ("second".equals(spOne.getSelectedItem())
				&& "mil".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.SecondToMil(value);
			secondOut.setText(result);
		} else if ("second".equals(spOne.getSelectedItem())
				&& "revolution".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.SecondToRevolution(value);
			secondOut.setText(result);
		} else if ("second".equals(spOne.getSelectedItem())
				&& "quadrant".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.SecondToQuand(value);
			secondOut.setText(result);
		}

		else if ("sign".equals(spOne.getSelectedItem())
				&& "degree".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.SignToDegree(value);
			secondOut.setText(result);
		} else if ("sign".equals(spOne.getSelectedItem())
				&& "radian".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.SignToRadian(value);
			secondOut.setText(result);
		} else if ("sign".equals(spOne.getSelectedItem())
				&& "grad".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.SignToGrad(value);
			secondOut.setText(result);
		} else if ("sign".equals(spOne.getSelectedItem())
				&& "minute".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.SignToMinute(value);
			secondOut.setText(result);
		} else if ("sign".equals(spOne.getSelectedItem())
				&& "second".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.SignToSecond(value);
			secondOut.setText(result);
		} else if ("sign".equals(spOne.getSelectedItem())
				&& "sign".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.SignToSign(value);
			secondOut.setText(result);
		} else if ("sign".equals(spOne.getSelectedItem())
				&& "mil".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.SignToMil(value);
			secondOut.setText(result);
		} else if ("sign".equals(spOne.getSelectedItem())
				&& "revolution".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.SignToRevolution(value);
			secondOut.setText(result);
		} else if ("sign".equals(spOne.getSelectedItem())
				&& "quadrant".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.SignToQuand(value);
			secondOut.setText(result);
		}

		else if ("mil".equals(spOne.getSelectedItem())
				&& "degree".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.MilToDegree(value);
			secondOut.setText(result);
		} else if ("mil".equals(spOne.getSelectedItem())
				&& "radian".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.MilToRadian(value);
			secondOut.setText(result);
		} else if ("mil".equals(spOne.getSelectedItem())
				&& "grad".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.MilToGrad(value);
			secondOut.setText(result);
		} else if ("mil".equals(spOne.getSelectedItem())
				&& "minute".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.MilToMinute(value);
			secondOut.setText(result);
		} else if ("mil".equals(spOne.getSelectedItem())
				&& "second".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.MilToSecond(value);
			secondOut.setText(result);
		} else if ("mil".equals(spOne.getSelectedItem())
				&& "sign".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.MilToSign(value);
			secondOut.setText(result);
		} else if ("mil".equals(spOne.getSelectedItem())
				&& "mil".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.MilToMil(value);
			secondOut.setText(result);
		} else if ("mil".equals(spOne.getSelectedItem())
				&& "revolution".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.MilToRevolution(value);
			secondOut.setText(result);
		} else if ("mil".equals(spOne.getSelectedItem())
				&& "quadrant".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.MilToQuand(value);
			secondOut.setText(result);
		}

		else if ("revolution".equals(spOne.getSelectedItem())
				&& "degree".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.RevToDegree(value);
			secondOut.setText(result);
		} else if ("revolution".equals(spOne.getSelectedItem())
				&& "radian".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.RevToRadian(value);
			secondOut.setText(result);
		} else if ("revolution".equals(spOne.getSelectedItem())
				&& "grad".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.RevToGrad(value);
			secondOut.setText(result);
		} else if ("revolution".equals(spOne.getSelectedItem())
				&& "minute".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.RevToMinute(value);
			secondOut.setText(result);
		} else if ("revolution".equals(spOne.getSelectedItem())
				&& "second".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.RevToSecond(value);
			secondOut.setText(result);
		} else if ("revolution".equals(spOne.getSelectedItem())
				&& "sign".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.RevToSign(value);
			secondOut.setText(result);
		} else if ("revolution".equals(spOne.getSelectedItem())
				&& "mil".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.RevToMIl(value);
			secondOut.setText(result);
		} else if ("revolution".equals(spOne.getSelectedItem())
				&& "revolution".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.RevToRev(value);
			secondOut.setText(result);
		} else if ("revolution".equals(spOne.getSelectedItem())
				&& "quadrant".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.RevToQuand(value);
			secondOut.setText(result);
		}

		else if ("quadrant".equals(spOne.getSelectedItem())
				&& "degree".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.QuadrantToDegree(value);
			secondOut.setText(result);
		} else if ("quadrant".equals(spOne.getSelectedItem())
				&& "radian".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.QuadrantToRadian(value);
			secondOut.setText(result);
		} else if ("quadrant".equals(spOne.getSelectedItem())
				&& "grad".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.QuadrantToGrad(value);
			secondOut.setText(result);
		} else if ("quadrant".equals(spOne.getSelectedItem())
				&& "minute".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.QuadrantToMinute(value);
			secondOut.setText(result);
		} else if ("quadrant".equals(spOne.getSelectedItem())
				&& "second".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.QuadrantToSecond(value);
			secondOut.setText(result);
		} else if ("quadrant".equals(spOne.getSelectedItem())
				&& "sign".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.QuadrantToSign(value);
			secondOut.setText(result);
		} else if ("quadrant".equals(spOne.getSelectedItem())
				&& "mil".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.QuadrantToMIl(value);
			secondOut.setText(result);
		} else if ("quadrant".equals(spOne.getSelectedItem())
				&& "revolution".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.QuadrantToRadian(value);
			secondOut.setText(result);
		} else if ("quadrant".equals(spOne.getSelectedItem())
				&& "quadrant".equals(spTwo.getSelectedItem())) {
			String result = AngleMethod.QuadrantToRevolution(value);
			secondOut.setText(result);
		}

	}

	private void setLengthOperation() {

		String str = firstOut.getText().toString();
		double value = Double.valueOf(str);

		if ("Kilometer".equals(spOne.getSelectedItem())
				&& "Kilometer".equals(spTwo.getSelectedItem())) {
			String result = LenthMethod.KiloToKilomiter(value);
			secondOut.setText(result);
		} else if ("Kilometer".equals(spOne.getSelectedItem())
				&& "Meter".equals(spTwo.getSelectedItem())) {
			String result = LenthMethod.KiloToMeter(value);
			secondOut.setText(result);
		} else if ("Kilometer".equals(spOne.getSelectedItem())
				&& "Centimeter".equals(spTwo.getSelectedItem())) {
			String result = LenthMethod.KiloToCentimeter(value);
			secondOut.setText(result);
		} else if ("Kilometer".equals(spOne.getSelectedItem())
				&& "Millimeter".equals(spTwo.getSelectedItem())) {
			String result = LenthMethod.KiloToMillimeter(value);
			secondOut.setText(result);
		} else if ("Kilometer".equals(spOne.getSelectedItem())
				&& "Mile".equals(spTwo.getSelectedItem())) {
			String result = LenthMethod.KiloToMile(value);
			secondOut.setText(result);
		} else if ("Kilometer".equals(spOne.getSelectedItem())
				&& "Yard".equals(spTwo.getSelectedItem())) {
			String result = LenthMethod.KiloToYard(value);
			secondOut.setText(result);
		} else if ("Kilometer".equals(spOne.getSelectedItem())
				&& "Foot".equals(spTwo.getSelectedItem())) {
			String result = LenthMethod.KiloToFoot(value);
			secondOut.setText(result);
		} else if ("Kilometer".equals(spOne.getSelectedItem())
				&& "Inch".equals(spTwo.getSelectedItem())) {
			String result = LenthMethod.KiloToInch(value);
			secondOut.setText(result);
		}

		else if ("Meter".equals(spOne.getSelectedItem())
				&& "Kilometer".equals(spTwo.getSelectedItem())) {
			String result = LenthMethod.MeterTokilometer(value);
			secondOut.setText(result);
		} else if ("Meter".equals(spOne.getSelectedItem())
				&& "Meter".equals(spTwo.getSelectedItem())) {
			String result = LenthMethod.MeterToMeter(value);
			secondOut.setText(result);
		} else if ("Meter".equals(spOne.getSelectedItem())
				&& "Centimeter".equals(spTwo.getSelectedItem())) {
			String result = LenthMethod.MeterToCentimeter(value);
			secondOut.setText(result);
		} else if ("Meter".equals(spOne.getSelectedItem())
				&& "Millimeter".equals(spTwo.getSelectedItem())) {
			String result = LenthMethod.MeterToMillimeter(value);
			secondOut.setText(result);
		} else if ("Meter".equals(spOne.getSelectedItem())
				&& "Mile".equals(spTwo.getSelectedItem())) {
			String result = LenthMethod.MeterToMile(value);
			secondOut.setText(result);
		} else if ("Meter".equals(spOne.getSelectedItem())
				&& "Yard".equals(spTwo.getSelectedItem())) {
			String result = LenthMethod.MeterToYard(value);
			secondOut.setText(result);
		} else if ("Meter".equals(spOne.getSelectedItem())
				&& "Foot".equals(spTwo.getSelectedItem())) {
			String result = LenthMethod.MeterToFoot(value);
			secondOut.setText(result);
		} else if ("Meter".equals(spOne.getSelectedItem())
				&& "Inch".equals(spTwo.getSelectedItem())) {
			String result = LenthMethod.MeterToInch(value);
			secondOut.setText(result);
		}

		else if ("Centimeter".equals(spOne.getSelectedItem())
				&& "Kilometer".equals(spTwo.getSelectedItem())) {
			String result = LenthMethod.CentimeterTokilometer(value);
			secondOut.setText(result);
		} else if ("Centimeter".equals(spOne.getSelectedItem())
				&& "Meter".equals(spTwo.getSelectedItem())) {
			String result = LenthMethod.CentimeterToMiter(value);
			secondOut.setText(result);
		} else if ("Centimeter".equals(spOne.getSelectedItem())
				&& "Centimeter".equals(spTwo.getSelectedItem())) {
			String result = LenthMethod.CentimeterToCentimeter(value);
			secondOut.setText(result);
		} else if ("Centimeter".equals(spOne.getSelectedItem())
				&& "Millimeter".equals(spTwo.getSelectedItem())) {
			String result = LenthMethod.CentimeterToMillimeter(value);
			secondOut.setText(result);
		} else if ("Centimeter".equals(spOne.getSelectedItem())
				&& "Mile".equals(spTwo.getSelectedItem())) {
			String result = LenthMethod.CentimeterToMile(value);
			secondOut.setText(result);
		} else if ("Centimeter".equals(spOne.getSelectedItem())
				&& "Yard".equals(spTwo.getSelectedItem())) {
			String result = LenthMethod.CentimeterToYard(value);
			secondOut.setText(result);
		} else if ("Centimeter".equals(spOne.getSelectedItem())
				&& "Foot".equals(spTwo.getSelectedItem())) {
			String result = LenthMethod.CentimeterToFoot(value);
			secondOut.setText(result);
		} else if ("Centimeter".equals(spOne.getSelectedItem())
				&& "Inch".equals(spTwo.getSelectedItem())) {
			String result = LenthMethod.CentimeterToInch(value);
			secondOut.setText(result);
		}

		else if ("Millimeter".equals(spOne.getSelectedItem())
				&& "Kilometer".equals(spTwo.getSelectedItem())) {
			String result = LenthMethod.MillimeterTokilometer(value);
			secondOut.setText(result);
		} else if ("Millimeter".equals(spOne.getSelectedItem())
				&& "Meter".equals(spTwo.getSelectedItem())) {
			String result = LenthMethod.MillimeterToMiter(value);
			secondOut.setText(result);
		} else if ("Millimeter".equals(spOne.getSelectedItem())
				&& "Centimeter".equals(spTwo.getSelectedItem())) {
			String result = LenthMethod.MillimeterToCentimeter(value);
			secondOut.setText(result);
		} else if ("Millimeter".equals(spOne.getSelectedItem())
				&& "Millimeter".equals(spTwo.getSelectedItem())) {
			String result = LenthMethod.MillimeterToMillimeter(value);
			secondOut.setText(result);
		} else if ("Millimeter".equals(spOne.getSelectedItem())
				&& "Mile".equals(spTwo.getSelectedItem())) {
			String result = LenthMethod.MillimeterToMile(value);
			secondOut.setText(result);
		} else if ("Millimeter".equals(spOne.getSelectedItem())
				&& "Yard".equals(spTwo.getSelectedItem())) {
			String result = LenthMethod.MillimeterToYard(value);
			secondOut.setText(result);
		} else if ("Millimeter".equals(spOne.getSelectedItem())
				&& "Foot".equals(spTwo.getSelectedItem())) {
			String result = LenthMethod.MillimeterToFoot(value);
			secondOut.setText(result);
		} else if ("Millimeter".equals(spOne.getSelectedItem())
				&& "Inch".equals(spTwo.getSelectedItem())) {
			String result = LenthMethod.MillimeterToInch(value);
			secondOut.setText(result);
		}

		else if ("Mile".equals(spOne.getSelectedItem())
				&& "Kilometer".equals(spTwo.getSelectedItem())) {
			String result = LenthMethod.MileTokilometer(value);
			secondOut.setText(result);
		} else if ("Mile".equals(spOne.getSelectedItem())
				&& "Meter".equals(spTwo.getSelectedItem())) {
			String result = LenthMethod.MileToMiter(value);
			secondOut.setText(result);
		} else if ("Mile".equals(spOne.getSelectedItem())
				&& "Centimeter".equals(spTwo.getSelectedItem())) {
			String result = LenthMethod.MileToCentimeter(value);
			secondOut.setText(result);
		} else if ("Mile".equals(spOne.getSelectedItem())
				&& "Millimeter".equals(spTwo.getSelectedItem())) {
			String result = LenthMethod.MileToMillimeter(value);
			secondOut.setText(result);
		} else if ("Mile".equals(spOne.getSelectedItem())
				&& "Mile".equals(spTwo.getSelectedItem())) {
			String result = LenthMethod.MileToMile(value);
			secondOut.setText(result);
		} else if ("Mile".equals(spOne.getSelectedItem())
				&& "Yard".equals(spTwo.getSelectedItem())) {
			String result = LenthMethod.MileToYard(value);
			secondOut.setText(result);
		} else if ("Mile".equals(spOne.getSelectedItem())
				&& "Foot".equals(spTwo.getSelectedItem())) {
			String result = LenthMethod.MileToFoot(value);
			secondOut.setText(result);
		} else if ("Mile".equals(spOne.getSelectedItem())
				&& "Inch".equals(spTwo.getSelectedItem())) {
			String result = LenthMethod.MileToInch(value);
			secondOut.setText(result);
		}

		else if ("Yard".equals(spOne.getSelectedItem())
				&& "Kilometer".equals(spTwo.getSelectedItem())) {
			String result = LenthMethod.YardTokilometer(value);
			secondOut.setText(result);
		} else if ("Yard".equals(spOne.getSelectedItem())
				&& "Meter".equals(spTwo.getSelectedItem())) {
			String result = LenthMethod.YardToMiter(value);
			secondOut.setText(result);
		} else if ("Yard".equals(spOne.getSelectedItem())
				&& "Centimeter".equals(spTwo.getSelectedItem())) {
			String result = LenthMethod.YardToCentimeter(value);
			secondOut.setText(result);
		} else if ("Yard".equals(spOne.getSelectedItem())
				&& "Millimeter".equals(spTwo.getSelectedItem())) {
			String result = LenthMethod.YardToMillimeter(value);
			secondOut.setText(result);
		} else if ("Yard".equals(spOne.getSelectedItem())
				&& "Mile".equals(spTwo.getSelectedItem())) {
			String result = LenthMethod.YardToMile(value);
			secondOut.setText(result);
		} else if ("Yard".equals(spOne.getSelectedItem())
				&& "Yard".equals(spTwo.getSelectedItem())) {
			String result = LenthMethod.YardToYard(value);
			secondOut.setText(result);
		} else if ("Yard".equals(spOne.getSelectedItem())
				&& "Foot".equals(spTwo.getSelectedItem())) {
			String result = LenthMethod.YardToFoot(value);
			secondOut.setText(result);
		} else if ("Yard".equals(spOne.getSelectedItem())
				&& "Inch".equals(spTwo.getSelectedItem())) {
			String result = LenthMethod.YardToInch(value);
			secondOut.setText(result);
		}

		else if ("Foot".equals(spOne.getSelectedItem())
				&& "Kilometer".equals(spTwo.getSelectedItem())) {
			String result = LenthMethod.FootTokilometer(value);
			secondOut.setText(result);
		} else if ("Foot".equals(spOne.getSelectedItem())
				&& "Meter".equals(spTwo.getSelectedItem())) {
			String result = LenthMethod.YardToMiter(value);
			secondOut.setText(result);
		} else if ("Foot".equals(spOne.getSelectedItem())
				&& "Centimeter".equals(spTwo.getSelectedItem())) {
			String result = LenthMethod.FootToCentimeter(value);
			secondOut.setText(result);
		} else if ("Foot".equals(spOne.getSelectedItem())
				&& "Millimeter".equals(spTwo.getSelectedItem())) {
			String result = LenthMethod.FootToMillimeter(value);
			secondOut.setText(result);
		} else if ("Foot".equals(spOne.getSelectedItem())
				&& "Mile".equals(spTwo.getSelectedItem())) {
			String result = LenthMethod.FootToMile(value);
			secondOut.setText(result);
		} else if ("Foot".equals(spOne.getSelectedItem())
				&& "Yard".equals(spTwo.getSelectedItem())) {
			String result = LenthMethod.FootToYard(value);
			secondOut.setText(result);
		} else if ("Foot".equals(spOne.getSelectedItem())
				&& "Foot".equals(spTwo.getSelectedItem())) {
			String result = LenthMethod.FootToFoot(value);
			secondOut.setText(result);
		} else if ("Foot".equals(spOne.getSelectedItem())
				&& "Inch".equals(spTwo.getSelectedItem())) {
			String result = LenthMethod.FootToInch(value);
			secondOut.setText(result);
		}

		else if ("Inch".equals(spOne.getSelectedItem())
				&& "Kilometer".equals(spTwo.getSelectedItem())) {
			String result = LenthMethod.InchTokilometer(value);
			secondOut.setText(result);
		} else if ("Inch".equals(spOne.getSelectedItem())
				&& "Meter".equals(spTwo.getSelectedItem())) {
			String result = LenthMethod.InchToMiter(value);
			secondOut.setText(result);
		} else if ("Inch".equals(spOne.getSelectedItem())
				&& "Centimeter".equals(spTwo.getSelectedItem())) {
			String result = LenthMethod.InchToCentimeter(value);
			secondOut.setText(result);
		} else if ("Inch".equals(spOne.getSelectedItem())
				&& "Millimeter".equals(spTwo.getSelectedItem())) {
			String result = LenthMethod.InchToMillimeter(value);
			secondOut.setText(result);
		} else if ("Inch".equals(spOne.getSelectedItem())
				&& "Mile".equals(spTwo.getSelectedItem())) {
			String result = LenthMethod.InchToMile(value);
			secondOut.setText(result);
		} else if ("Inch".equals(spOne.getSelectedItem())
				&& "Yard".equals(spTwo.getSelectedItem())) {
			String result = LenthMethod.InchToYard(value);
			secondOut.setText(result);
		} else if ("Inch".equals(spOne.getSelectedItem())
				&& "Foot".equals(spTwo.getSelectedItem())) {
			String result = LenthMethod.InchToFoot(value);
			secondOut.setText(result);
		} else if ("Inch".equals(spOne.getSelectedItem())
				&& "Inch".equals(spTwo.getSelectedItem())) {
			String result = LenthMethod.InchToInch(value);
			secondOut.setText(result);
		}

	}

	private void setDigitalStorageOperation() {

		String str = firstOut.getText().toString();
		double value = Double.valueOf(str);

		if ("bit".equals(spOne.getSelectedItem())
				&& "bit".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.bitTobit(value);
			secondOut.setText(result);
		} else if ("bit".equals(spOne.getSelectedItem())
				&& "byte".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.bitTobyte(value);
			secondOut.setText(result);
		} else if ("bit".equals(spOne.getSelectedItem())
				&& "kilobit".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.bitTokilobit(value);
			secondOut.setText(result);
		} else if ("bit".equals(spOne.getSelectedItem())
				&& "kilobyte".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.bitToKilobyte(value);
			secondOut.setText(result);
		} else if ("bit".equals(spOne.getSelectedItem())
				&& "megabit".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.bitTomegabit(value);
			secondOut.setText(result);
		} else if ("bit".equals(spOne.getSelectedItem())
				&& "megabyte".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.bitTomegabyte(value);
			secondOut.setText(result);
		} else if ("bit".equals(spOne.getSelectedItem())
				&& "gigabit".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.bitTogigabit(value);
			secondOut.setText(result);
		} else if ("bit".equals(spOne.getSelectedItem())
				&& "gigabyte".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.bitTogigabyte(value);
			secondOut.setText(result);
		} else if ("bit".equals(spOne.getSelectedItem())
				&& "terabit".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.bitToterabit(value);
			secondOut.setText(result);
		} else if ("bit".equals(spOne.getSelectedItem())
				&& "terabyte".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.bitToterabyte(value);
			secondOut.setText(result);
		}

		else if ("byte".equals(spOne.getSelectedItem())
				&& "bit".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.byteTobit(value);
			secondOut.setText(result);
		} else if ("byte".equals(spOne.getSelectedItem())
				&& "byte".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.byteTobyte(value);
			secondOut.setText(result);
		} else if ("byte".equals(spOne.getSelectedItem())
				&& "kilobit".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.byteTokilobit(value);
			secondOut.setText(result);
		} else if ("byte".equals(spOne.getSelectedItem())
				&& "kilobyte".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.byteToKilobyte(value);
			secondOut.setText(result);
		} else if ("byte".equals(spOne.getSelectedItem())
				&& "megabit".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.byteTomegabit(value);
			secondOut.setText(result);
		} else if ("byte".equals(spOne.getSelectedItem())
				&& "megabyte".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.byteTomegabyte(value);
			secondOut.setText(result);
		} else if ("byte".equals(spOne.getSelectedItem())
				&& "gigabit".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.byteTogigabit(value);
			secondOut.setText(result);
		} else if ("byte".equals(spOne.getSelectedItem())
				&& "gigabyte".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.byteTogigabyte(value);
			secondOut.setText(result);
		} else if ("byte".equals(spOne.getSelectedItem())
				&& "terabit".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.byteToterabit(value);
			secondOut.setText(result);
		} else if ("byte".equals(spOne.getSelectedItem())
				&& "terabyte".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.byteToterabyte(value);
			secondOut.setText(result);
		}

		else if ("kilobit".equals(spOne.getSelectedItem())
				&& "bit".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.kilobitTobit(value);
			secondOut.setText(result);
		} else if ("kilobit".equals(spOne.getSelectedItem())
				&& "byte".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.kilobitTobyte(value);
			secondOut.setText(result);
		} else if ("kilobit".equals(spOne.getSelectedItem())
				&& "kilobit".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.kilobitTokilobit(value);
			secondOut.setText(result);
		} else if ("kilobit".equals(spOne.getSelectedItem())
				&& "kilobyte".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.kilobitToKilobyte(value);
			secondOut.setText(result);
		} else if ("kilobit".equals(spOne.getSelectedItem())
				&& "megabit".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.kilobitTomegabit(value);
			secondOut.setText(result);
		} else if ("kilobit".equals(spOne.getSelectedItem())
				&& "megabyte".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.kilobitTomegabyte(value);
			secondOut.setText(result);
		} else if ("kilobit".equals(spOne.getSelectedItem())
				&& "gigabit".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.kilobitTogigabit(value);
			secondOut.setText(result);
		} else if ("kilobit".equals(spOne.getSelectedItem())
				&& "gigabyte".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.kilobitTogigabyte(value);
			secondOut.setText(result);
		} else if ("kilobit".equals(spOne.getSelectedItem())
				&& "terabit".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.kilobitToterabit(value);
			secondOut.setText(result);
		} else if ("kilobit".equals(spOne.getSelectedItem())
				&& "terabyte".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.kilobitToterabyte(value);
			secondOut.setText(result);
		}

		else if ("kilobyte".equals(spOne.getSelectedItem())
				&& "bit".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.kilobyteTobit(value);
			secondOut.setText(result);
		} else if ("kilobyte".equals(spOne.getSelectedItem())
				&& "byte".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.kilobyteTobyte(value);
			secondOut.setText(result);
		} else if ("kilobyte".equals(spOne.getSelectedItem())
				&& "kilobit".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.kilobyteTokilobit(value);
			secondOut.setText(result);
		} else if ("kilobyte".equals(spOne.getSelectedItem())
				&& "kilobyte".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.kilobyteTokilobyte(value);
			secondOut.setText(result);
		} else if ("kilobyte".equals(spOne.getSelectedItem())
				&& "megabit".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.kilobyteTomegabit(value);
			secondOut.setText(result);
		} else if ("kilobyte".equals(spOne.getSelectedItem())
				&& "megabyte".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.kilobyteTomegabyte(value);
			secondOut.setText(result);
		} else if ("kilobyte".equals(spOne.getSelectedItem())
				&& "gigabit".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.kilobyteTogigabit(value);
			secondOut.setText(result);
		} else if ("kilobyte".equals(spOne.getSelectedItem())
				&& "gigabyte".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.kilobyteTogigabyte(value);
			secondOut.setText(result);
		} else if ("kilobyte".equals(spOne.getSelectedItem())
				&& "terabit".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.kilobyteToterabit(value);
			secondOut.setText(result);
		} else if ("kilobyte".equals(spOne.getSelectedItem())
				&& "terabyte".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.kilobyteToterabyte(value);
			secondOut.setText(result);
		}

		else if ("megabit".equals(spOne.getSelectedItem())
				&& "bit".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.megabitTobit(value);
			secondOut.setText(result);
		} else if ("megabit".equals(spOne.getSelectedItem())
				&& "byte".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.megabitTobyte(value);
			secondOut.setText(result);
		} else if ("megabit".equals(spOne.getSelectedItem())
				&& "kilobit".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.megabitTokilobit(value);
			secondOut.setText(result);
		} else if ("megabit".equals(spOne.getSelectedItem())
				&& "kilobyte".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.megabitTokilobyte(value);
			secondOut.setText(result);
		} else if ("megabit".equals(spOne.getSelectedItem())
				&& "megabit".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.megabitTomegabit(value);
			secondOut.setText(result);
		} else if ("megabit".equals(spOne.getSelectedItem())
				&& "megabyte".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.megabitTomegabyte(value);
			secondOut.setText(result);
		} else if ("megabit".equals(spOne.getSelectedItem())
				&& "gigabit".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.megabitTogigabit(value);
			secondOut.setText(result);
		} else if ("megabit".equals(spOne.getSelectedItem())
				&& "gigabyte".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.megabitTogigabyte(value);
			secondOut.setText(result);
		} else if ("megabit".equals(spOne.getSelectedItem())
				&& "terabit".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.megabitToterabit(value);
			secondOut.setText(result);
		} else if ("megabit".equals(spOne.getSelectedItem())
				&& "terabyte".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.megabitToterabyte(value);
			secondOut.setText(result);
		}

		else if ("megabyte".equals(spOne.getSelectedItem())
				&& "bit".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.megabyteTobit(value);
			secondOut.setText(result);
		} else if ("megabyte".equals(spOne.getSelectedItem())
				&& "byte".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.megabyteTobyte(value);
			secondOut.setText(result);
		} else if ("megabyte".equals(spOne.getSelectedItem())
				&& "kilobit".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.megabyteTokilobit(value);
			secondOut.setText(result);
		} else if ("megabyte".equals(spOne.getSelectedItem())
				&& "kilobyte".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.megabyteTokilobyte(value);
			secondOut.setText(result);
		} else if ("megabyte".equals(spOne.getSelectedItem())
				&& "megabit".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.megabyteTomegabit(value);
			secondOut.setText(result);
		} else if ("megabyte".equals(spOne.getSelectedItem())
				&& "megabyte".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.megabyteTomegabyte(value);
			secondOut.setText(result);
		} else if ("megabyte".equals(spOne.getSelectedItem())
				&& "gigabit".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.megabyteTogigabit(value);
			secondOut.setText(result);
		} else if ("megabyte".equals(spOne.getSelectedItem())
				&& "gigabyte".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.megabyteTogigabyte(value);
			secondOut.setText(result);
		} else if ("megabyte".equals(spOne.getSelectedItem())
				&& "terabit".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.megabyteToterabit(value);
			secondOut.setText(result);
		} else if ("megabyte".equals(spOne.getSelectedItem())
				&& "terabyte".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.megabyteToterabyte(value);
			secondOut.setText(result);
		}

		else if ("gigabit".equals(spOne.getSelectedItem())
				&& "bit".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.gigabitTobit(value);
			secondOut.setText(result);
		} else if ("gigabit".equals(spOne.getSelectedItem())
				&& "byte".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.gigabitTobyte(value);
			secondOut.setText(result);
		} else if ("gigabit".equals(spOne.getSelectedItem())
				&& "kilobit".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.gigabitTokilobit(value);
			secondOut.setText(result);
		} else if ("gigabit".equals(spOne.getSelectedItem())
				&& "kilobyte".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.gigabitTokilobyte(value);
			secondOut.setText(result);
		} else if ("gigabit".equals(spOne.getSelectedItem())
				&& "megabit".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.gigabitTomegabit(value);
			secondOut.setText(result);
		} else if ("gigabit".equals(spOne.getSelectedItem())
				&& "megabyte".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.gigabitTomegabyte(value);
			secondOut.setText(result);
		} else if ("gigabit".equals(spOne.getSelectedItem())
				&& "gigabit".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.gigabitTogigabit(value);
			secondOut.setText(result);
		} else if ("gigabit".equals(spOne.getSelectedItem())
				&& "gigabyte".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.gigabitTogigabyte(value);
			secondOut.setText(result);
		} else if ("gigabit".equals(spOne.getSelectedItem())
				&& "terabit".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.gigabitToterabit(value);
			secondOut.setText(result);
		} else if ("gigabit".equals(spOne.getSelectedItem())
				&& "terabyte".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.gigabitToterabyte(value);
			secondOut.setText(result);
		}

		else if ("gigabyte".equals(spOne.getSelectedItem())
				&& "bit".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.gigabyteTobit(value);
			secondOut.setText(result);
		} else if ("gigabyte".equals(spOne.getSelectedItem())
				&& "byte".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.gigabyteTobyte(value);
			secondOut.setText(result);
		} else if ("gigabyte".equals(spOne.getSelectedItem())
				&& "kilobit".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.gigabyteTokilobit(value);
			secondOut.setText(result);
		} else if ("gigabyte".equals(spOne.getSelectedItem())
				&& "kilobyte".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.gigabyteTokilobyte(value);
			secondOut.setText(result);
		} else if ("gigabyte".equals(spOne.getSelectedItem())
				&& "megabit".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.gigabyteTomegabit(value);
			secondOut.setText(result);
		} else if ("gigabyte".equals(spOne.getSelectedItem())
				&& "megabyte".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.gigabyteTomegabyte(value);
			secondOut.setText(result);
		} else if ("gigabyte".equals(spOne.getSelectedItem())
				&& "gigabit".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.gigabyteTogigabit(value);
			secondOut.setText(result);
		} else if ("gigabyte".equals(spOne.getSelectedItem())
				&& "gigabyte".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.gigabyteTogigabyte(value);
			secondOut.setText(result);
		} else if ("gigabyte".equals(spOne.getSelectedItem())
				&& "terabit".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.gigabyteToterabit(value);
			secondOut.setText(result);
		} else if ("gigabyte".equals(spOne.getSelectedItem())
				&& "terabyte".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.gigabyteToterabyte(value);
			secondOut.setText(result);
		}

		else if ("terabit".equals(spOne.getSelectedItem())
				&& "bit".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.terabitTobit(value);
			secondOut.setText(result);
		} else if ("terabit".equals(spOne.getSelectedItem())
				&& "byte".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.terabitTobyte(value);
			secondOut.setText(result);
		} else if ("terabit".equals(spOne.getSelectedItem())
				&& "kilobit".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.terabitTokilobit(value);
			secondOut.setText(result);
		} else if ("terabit".equals(spOne.getSelectedItem())
				&& "kilobyte".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.terabitTokilobyte(value);
			secondOut.setText(result);
		} else if ("terabit".equals(spOne.getSelectedItem())
				&& "megabit".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.terabitTomegabit(value);
			secondOut.setText(result);
		} else if ("terabit".equals(spOne.getSelectedItem())
				&& "megabyte".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.terabitTomegabyte(value);
			secondOut.setText(result);
		} else if ("terabit".equals(spOne.getSelectedItem())
				&& "gigabit".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.terabitTogigabit(value);
			secondOut.setText(result);
		} else if ("terabit".equals(spOne.getSelectedItem())
				&& "gigabyte".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.terabitTogigabyte(value);
			secondOut.setText(result);
		} else if ("terabit".equals(spOne.getSelectedItem())
				&& "terabit".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.terabitToterabit(value);
			secondOut.setText(result);
		} else if ("terabit".equals(spOne.getSelectedItem())
				&& "terabyte".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.terabitToterabyte(value);
			secondOut.setText(result);
		}

		else if ("terabyte".equals(spOne.getSelectedItem())
				&& "bit".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.terabyteTobit(value);
			secondOut.setText(result);
		} else if ("terabyte".equals(spOne.getSelectedItem())
				&& "byte".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.terabyteTobyte(value);
			secondOut.setText(result);
		} else if ("terabyte".equals(spOne.getSelectedItem())
				&& "kilobit".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.terabyteTokilobit(value);
			secondOut.setText(result);
		} else if ("terabyte".equals(spOne.getSelectedItem())
				&& "kilobyte".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.terabyteTokilobyte(value);
			secondOut.setText(result);
		} else if ("terabyte".equals(spOne.getSelectedItem())
				&& "megabit".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.terabyteTomegabit(value);
			secondOut.setText(result);
		} else if ("terabyte".equals(spOne.getSelectedItem())
				&& "megabyte".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.terabyteTomegabyte(value);
			secondOut.setText(result);
		} else if ("terabyte".equals(spOne.getSelectedItem())
				&& "gigabit".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.terabyteTogigabit(value);
			secondOut.setText(result);
		} else if ("terabyte".equals(spOne.getSelectedItem())
				&& "gigabyte".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.terabyteTogigabyte(value);
			secondOut.setText(result);
		} else if ("terabyte".equals(spOne.getSelectedItem())
				&& "terabit".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.terabyteToterabit(value);
			secondOut.setText(result);
		} else if ("terabyte".equals(spOne.getSelectedItem())
				&& "terabyte".equals(spTwo.getSelectedItem())) {
			String result = DatastorageMethod.terabyteToterabyte(value);
			secondOut.setText(result);
		}

	}

	private void setTempetureOperation() {
		String str = firstOut.getText().toString();
		double value = Double.valueOf(str);

		if ("Celsius".equals(spOne.getSelectedItem())
				&& "Kelvin".equals(spTwo.getSelectedItem())) {
			String result = TempatureMetho.CelToKal(value);
			secondOut.setText(result);
		} else if ("Celsius".equals(spOne.getSelectedItem())
				&& "Celsius".equals(spTwo.getSelectedItem())) {
			String result = TempatureMetho.CelToCel(value);
			secondOut.setText(result);
		} else if ("Celsius".equals(spOne.getSelectedItem())
				&& "Fahrenheit".equals(spTwo.getSelectedItem())) {
			String result = TempatureMetho.CelToFar(value);
			secondOut.setText(result);
		} else if ("Fahrenheit".equals(spOne.getSelectedItem())
				&& "Fahrenheit".equals(spTwo.getSelectedItem())) {
			String result = TempatureMetho.FaToFa(value);
			secondOut.setText(result);
		} else if ("Fahrenheit".equals(spOne.getSelectedItem())
				&& "Celsius".equals(spTwo.getSelectedItem())) {
			String result = TempatureMetho.FarToCel(value);
			secondOut.setText(result);
		} else if ("Fahrenheit".equals(spOne.getSelectedItem())
				&& "Kelvin".equals(spTwo.getSelectedItem())) {
			String result = TempatureMetho.FarToKal(value);
			secondOut.setText(result);
		} else if ("Kelvin".equals(spOne.getSelectedItem())
				&& "Kelvin".equals(spTwo.getSelectedItem())) {
			String result = TempatureMetho.KalToKal(value);
			secondOut.setText(result);
		} else if ("Kelvin".equals(spOne.getSelectedItem())
				&& "Fahrenheit".equals(spTwo.getSelectedItem())) {
			String result = TempatureMetho.KalToFar(value);
			secondOut.setText(result);
		} else if ("Kelvin".equals(spOne.getSelectedItem())
				&& "Celsius".equals(spTwo.getSelectedItem())) {
			String result = TempatureMetho.KalToCel(value);
			secondOut.setText(result);
		}

	}

	private void setTimeOperation() {
		String str = firstOut.getText().toString();
		double value = Double.valueOf(str);

		if ("Nanosecond".equals(spOne.getSelectedItem())
				&& "Nanosecond".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.NanosecondToNanosecond(value);
			secondOut.setText(result);
		} else if ("Nanosecond".equals(spOne.getSelectedItem())
				&& "Microsecond".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.NanosecondToMicrosecond(value);
			secondOut.setText(result);
		} else if ("Nanosecond".equals(spOne.getSelectedItem())
				&& "Millisecond".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.NanosecondToMillisecond(value);
			secondOut.setText(result);
		} else if ("Nanosecond".equals(spOne.getSelectedItem())
				&& "Second".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.NanosecondTosecond(value);
			secondOut.setText(result);
		} else if ("Nanosecond".equals(spOne.getSelectedItem())
				&& "Minute".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.NanosecondToMinute(value);
			secondOut.setText(result);
		} else if ("Nanosecond".equals(spOne.getSelectedItem())
				&& "Hour".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.NanosecondToHour(value);
			secondOut.setText(result);
		} else if ("Nanosecond".equals(spOne.getSelectedItem())
				&& "Day".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.NanosecondToDay(value);
			secondOut.setText(result);
		} else if ("Nanosecond".equals(spOne.getSelectedItem())
				&& "Week".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.NanosecondToWeek(value);
			secondOut.setText(result);
		} else if ("Nanosecond".equals(spOne.getSelectedItem())
				&& "Month".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.NanosecondToMonth(value);
			secondOut.setText(result);
		} else if ("Nanosecond".equals(spOne.getSelectedItem())
				&& "Year".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.NanosecondToYear(value);
			secondOut.setText(result);
		}

		else if ("Microsecond".equals(spOne.getSelectedItem())
				&& "Nanosecond".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.MicrosecondToNanosecond(value);
			secondOut.setText(result);
		} else if ("Microsecond".equals(spOne.getSelectedItem())
				&& "Microsecond".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.MicrosecondToMicrosecond(value);
			secondOut.setText(result);
		} else if ("Microsecond".equals(spOne.getSelectedItem())
				&& "Millisecond".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.MicrosecondToMillisecond(value);
			secondOut.setText(result);
		} else if ("Microsecond".equals(spOne.getSelectedItem())
				&& "Second".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.MicrosecondTosecond(value);
			secondOut.setText(result);
		} else if ("Microsecond".equals(spOne.getSelectedItem())
				&& "Minute".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.MicrosecondToMinute(value);
			secondOut.setText(result);
		} else if ("Microsecond".equals(spOne.getSelectedItem())
				&& "Hour".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.MicrosecondToHour(value);
			secondOut.setText(result);
		} else if ("Microsecond".equals(spOne.getSelectedItem())
				&& "Day".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.MicrosecondToDay(value);
			secondOut.setText(result);
		} else if ("Microsecond".equals(spOne.getSelectedItem())
				&& "Week".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.MicrosecondToWeek(value);
			secondOut.setText(result);
		} else if ("Microsecond".equals(spOne.getSelectedItem())
				&& "Month".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.MicrosecondToMonth(value);
			secondOut.setText(result);
		} else if ("Microsecond".equals(spOne.getSelectedItem())
				&& "Year".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.MicrosecondToYear(value);
			secondOut.setText(result);
		}

		else if ("Millisecond".equals(spOne.getSelectedItem())
				&& "Nanosecond".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.MillisecondToNanosecond(value);
			secondOut.setText(result);
		} else if ("Millisecond".equals(spOne.getSelectedItem())
				&& "Microsecond".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.MillisecondToMicrosecond(value);
			secondOut.setText(result);
		} else if ("Millisecond".equals(spOne.getSelectedItem())
				&& "Millisecond".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.MillisecondToMillisecond(value);
			secondOut.setText(result);
		} else if ("Millisecond".equals(spOne.getSelectedItem())
				&& "Second".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.MillisecondTosecond(value);
			secondOut.setText(result);
		} else if ("Millisecond".equals(spOne.getSelectedItem())
				&& "Minute".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.MillisecondToMinute(value);
			secondOut.setText(result);
		} else if ("Millisecond".equals(spOne.getSelectedItem())
				&& "Hour".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.MillisecondToHour(value);
			secondOut.setText(result);
		} else if ("Millisecond".equals(spOne.getSelectedItem())
				&& "Day".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.MillisecondToDay(value);
			secondOut.setText(result);
		} else if ("Millisecond".equals(spOne.getSelectedItem())
				&& "Week".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.MillisecondToWeek(value);
			secondOut.setText(result);
		} else if ("Millisecond".equals(spOne.getSelectedItem())
				&& "Month".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.MillisecondToMonth(value);
			secondOut.setText(result);
		} else if ("Millisecond".equals(spOne.getSelectedItem())
				&& "Year".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.MillisecondToYear(value);
			secondOut.setText(result);
		}

		else if ("Second".equals(spOne.getSelectedItem())
				&& "Nanosecond".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.SecondToNanosecond(value);
			secondOut.setText(result);
		} else if ("Second".equals(spOne.getSelectedItem())
				&& "Microsecond".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.SecondToMicrosecond(value);
			secondOut.setText(result);
		} else if ("Second".equals(spOne.getSelectedItem())
				&& "Millisecond".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.SecondToMillisecond(value);
			secondOut.setText(result);
		} else if ("Second".equals(spOne.getSelectedItem())
				&& "Second".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.SecondToSecond(value);
			secondOut.setText(result);
		} else if ("Second".equals(spOne.getSelectedItem())
				&& "Minute".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.SecondToMinute(value);
			secondOut.setText(result);
		} else if ("Second".equals(spOne.getSelectedItem())
				&& "Hour".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.SecondToHour(value);
			secondOut.setText(result);
		} else if ("Second".equals(spOne.getSelectedItem())
				&& "Day".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.SecondToDay(value);
			secondOut.setText(result);
		} else if ("Second".equals(spOne.getSelectedItem())
				&& "Week".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.SecondToWeek(value);
			secondOut.setText(result);
		} else if ("Second".equals(spOne.getSelectedItem())
				&& "Month".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.SecondToMonth(value);
			secondOut.setText(result);
		} else if ("Second".equals(spOne.getSelectedItem())
				&& "Year".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.SecondToYear(value);
			secondOut.setText(result);
		}

		else if ("Minute".equals(spOne.getSelectedItem())
				&& "Nanosecond".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.MinuteToNanosecond(value);
			secondOut.setText(result);
		} else if ("Minute".equals(spOne.getSelectedItem())
				&& "Microsecond".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.MinuteToMicrosecond(value);
			secondOut.setText(result);
		} else if ("Minute".equals(spOne.getSelectedItem())
				&& "Millisecond".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.MinuteToMillisecond(value);
			secondOut.setText(result);
		} else if ("Minute".equals(spOne.getSelectedItem())
				&& "Second".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.MinuteToSecond(value);
			secondOut.setText(result);
		} else if ("Minute".equals(spOne.getSelectedItem())
				&& "Minute".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.MinuteToMinute(value);
			secondOut.setText(result);
		} else if ("Minute".equals(spOne.getSelectedItem())
				&& "Hour".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.MinuteToHour(value);
			secondOut.setText(result);
		} else if ("Minute".equals(spOne.getSelectedItem())
				&& "Day".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.MinuteToDay(value);
			secondOut.setText(result);
		} else if ("Minute".equals(spOne.getSelectedItem())
				&& "Week".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.MinuteToWeek(value);
			secondOut.setText(result);
		} else if ("Minute".equals(spOne.getSelectedItem())
				&& "Month".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.MinuteToMonth(value);
			secondOut.setText(result);
		} else if ("Minute".equals(spOne.getSelectedItem())
				&& "Year".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.MinuteToYear(value);
			secondOut.setText(result);
		}

		else if ("Hour".equals(spOne.getSelectedItem())
				&& "Nanosecond".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.HourToNanosecond(value);
			secondOut.setText(result);
		} else if ("Hour".equals(spOne.getSelectedItem())
				&& "Microsecond".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.HourToMicrosecond(value);
			secondOut.setText(result);
		} else if ("Hour".equals(spOne.getSelectedItem())
				&& "Millisecond".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.HourToMillisecond(value);
			secondOut.setText(result);
		} else if ("Hour".equals(spOne.getSelectedItem())
				&& "Second".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.HourToSecond(value);
			secondOut.setText(result);
		} else if ("Hour".equals(spOne.getSelectedItem())
				&& "Minute".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.HourToMinute(value);
			secondOut.setText(result);
		} else if ("Hour".equals(spOne.getSelectedItem())
				&& "Hour".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.HourToHour(value);
			secondOut.setText(result);
		} else if ("Hour".equals(spOne.getSelectedItem())
				&& "Day".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.HourToDay(value);
			secondOut.setText(result);
		} else if ("Hour".equals(spOne.getSelectedItem())
				&& "Week".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.HourToWeek(value);
			secondOut.setText(result);
		} else if ("Hour".equals(spOne.getSelectedItem())
				&& "Month".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.HourToMonth(value);
			secondOut.setText(result);
		} else if ("Hour".equals(spOne.getSelectedItem())
				&& "Year".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.HourToYear(value);
			secondOut.setText(result);
		}

		else if ("Day".equals(spOne.getSelectedItem())
				&& "Nanosecond".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.DayToNanosecond(value);
			secondOut.setText(result);
		} else if ("Day".equals(spOne.getSelectedItem())
				&& "Microsecond".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.DayToMicrosecond(value);
			secondOut.setText(result);
		} else if ("Day".equals(spOne.getSelectedItem())
				&& "Millisecond".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.DayToMillisecond(value);
			secondOut.setText(result);
		} else if ("Day".equals(spOne.getSelectedItem())
				&& "Second".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.MinuteToSecond(value);
			secondOut.setText(result);
		} else if ("Day".equals(spOne.getSelectedItem())
				&& "Minute".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.DayToMinute(value);
			secondOut.setText(result);
		} else if ("Day".equals(spOne.getSelectedItem())
				&& "Hour".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.DayToHour(value);
			secondOut.setText(result);
		} else if ("Day".equals(spOne.getSelectedItem())
				&& "Day".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.DayToDay(value);
			secondOut.setText(result);
		} else if ("Day".equals(spOne.getSelectedItem())
				&& "Week".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.DayToWeek(value);
			secondOut.setText(result);
		} else if ("Day".equals(spOne.getSelectedItem())
				&& "Month".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.DayToMonth(value);
			secondOut.setText(result);
		} else if ("Day".equals(spOne.getSelectedItem())
				&& "Year".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.DayToYear(value);
			secondOut.setText(result);
		}

		else if ("Week".equals(spOne.getSelectedItem())
				&& "Nanosecond".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.WeekToNanosecond(value);
			secondOut.setText(result);
		} else if ("Week".equals(spOne.getSelectedItem())
				&& "Microsecond".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.WeekToMicrosecond(value);
			secondOut.setText(result);
		} else if ("Week".equals(spOne.getSelectedItem())
				&& "Millisecond".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.WeekToMillisecond(value);
			secondOut.setText(result);
		} else if ("Week".equals(spOne.getSelectedItem())
				&& "Second".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.WeekToSecond(value);
			secondOut.setText(result);
		} else if ("Week".equals(spOne.getSelectedItem())
				&& "Minute".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.WeekToMinute(value);
			secondOut.setText(result);
		} else if ("Week".equals(spOne.getSelectedItem())
				&& "Hour".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.WeekToHour(value);
			secondOut.setText(result);
		} else if ("Week".equals(spOne.getSelectedItem())
				&& "Day".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.WeekToDay(value);
			secondOut.setText(result);
		} else if ("Week".equals(spOne.getSelectedItem())
				&& "Week".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.WeekToWeek(value);
			secondOut.setText(result);
		} else if ("Week".equals(spOne.getSelectedItem())
				&& "Month".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.WeekToMonth(value);
			secondOut.setText(result);
		} else if ("Week".equals(spOne.getSelectedItem())
				&& "Year".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.WeekToYear(value);
			secondOut.setText(result);
		}

		else if ("Month".equals(spOne.getSelectedItem())
				&& "Nanosecond".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.MonthToNanosecond(value);
			secondOut.setText(result);
		} else if ("Month".equals(spOne.getSelectedItem())
				&& "Microsecond".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.MonthToMicrosecond(value);
			secondOut.setText(result);
		} else if ("Month".equals(spOne.getSelectedItem())
				&& "Millisecond".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.MonthToMillisecond(value);
			secondOut.setText(result);
		} else if ("Month".equals(spOne.getSelectedItem())
				&& "Second".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.MonthToSecond(value);
			secondOut.setText(result);
		} else if ("Month".equals(spOne.getSelectedItem())
				&& "Minute".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.MonthToMinute(value);
			secondOut.setText(result);
		} else if ("Month".equals(spOne.getSelectedItem())
				&& "Hour".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.MonthToHour(value);
			secondOut.setText(result);
		} else if ("Month".equals(spOne.getSelectedItem())
				&& "Day".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.MonthToDay(value);
			secondOut.setText(result);
		} else if ("Month".equals(spOne.getSelectedItem())
				&& "Week".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.MonthToWeek(value);
			secondOut.setText(result);
		} else if ("Month".equals(spOne.getSelectedItem())
				&& "Month".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.MonthToMonth(value);
			secondOut.setText(result);
		} else if ("Month".equals(spOne.getSelectedItem())
				&& "Year".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.MonthToYear(value);
			secondOut.setText(result);
		}

		else if ("Year".equals(spOne.getSelectedItem())
				&& "Nanosecond".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.YearToNanosecond(value);
			secondOut.setText(result);
		} else if ("Year".equals(spOne.getSelectedItem())
				&& "Microsecond".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.YearToMicrosecond(value);
			secondOut.setText(result);
		} else if ("Year".equals(spOne.getSelectedItem())
				&& "Millisecond".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.YearToMillisecond(value);
			secondOut.setText(result);
		} else if ("Year".equals(spOne.getSelectedItem())
				&& "Second".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.YearToSecond(value);
			secondOut.setText(result);
		} else if ("Year".equals(spOne.getSelectedItem())
				&& "Minute".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.YearToMinute(value);
			secondOut.setText(result);
		} else if ("Year".equals(spOne.getSelectedItem())
				&& "Hour".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.YearToHour(value);
			secondOut.setText(result);
		} else if ("Year".equals(spOne.getSelectedItem())
				&& "Day".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.YearToDay(value);
			secondOut.setText(result);
		} else if ("Year".equals(spOne.getSelectedItem())
				&& "Week".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.YearToWeek(value);
			secondOut.setText(result);
		} else if ("Year".equals(spOne.getSelectedItem())
				&& "Month".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.YearToMonth(value);
			secondOut.setText(result);
		} else if ("Year".equals(spOne.getSelectedItem())
				&& "Year".equals(spTwo.getSelectedItem())) {
			String result = TimeItemMethod.YearToYear(value);
			secondOut.setText(result);
		}
	}

}
